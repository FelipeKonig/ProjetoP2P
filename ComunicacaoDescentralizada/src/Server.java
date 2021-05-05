
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {

	private static Socket s;
	private static ServerSocket ss;
	private Client client;

	private int port;
	private int countMyRequest = 0;
	private boolean writeNewMsg = false;
	private String lastRequest[];

	public Server(int port, Client client) {
		this.port = port;
		this.client = client;
	}

	@Override
	public void run() {

		try {
			ss = new ServerSocket(port);

			System.out.println("\nServidor iniciou na porta: " + port + "\n");

			if (client.getMsg() == null) {
				System.out.println("\nDigite uma mensagem: \n");
			}

			while (true) {

				s = ss.accept();

				BufferedReader inFromClient = new BufferedReader(new InputStreamReader(s.getInputStream()));
				String requestString = inFromClient.readLine();

				String msg[] = requestString.split(" |port: ");

				System.out.println("Cliente porta: " + msg[msg.length - 1] + " enviou: " + msg[0]);

				boolean sameMsg = verifyMsg(msg);

				toDefine(sameMsg, requestString);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void toDefine(boolean sameMsg, String requestString) {
		if (sameMsg && countMyRequest == 2) {
			countMyRequest = 0;
			System.out.println("\nDigite uma mensagem: \n");
		} else if(writeNewMsg) {
			writeNewMsg = false;
			System.out.println("\nDigite uma mensagem: \n");
		} else if (!sameMsg) {
			client.writeMessage(requestString);
			System.out.println("\nServidor se tornou cliente \n");
			client.run();
		}
	}

	private boolean verifyMsg(String msg[]) {
		String portString = String.valueOf(port);

		if (msg[2].contains(portString)) {
			countMyRequest++;
			return true;
		}

		if (lastRequest != null) {
			if (lastRequest[0].contentEquals(msg[0])) {
				if (lastRequest[2].contentEquals(msg[2])) {
					writeNewMsg = true;
					return true;
				}
			}
		}

		lastRequest = msg;

		return false;
	}

}
