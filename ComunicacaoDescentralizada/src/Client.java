
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client extends Thread {

	private Socket socket;
	private final int portClient1, portClient2, portServer;
	private String msg;

	public Client(int port, int port2, int portServer) {
		this.portClient1 = port;
		this.portClient2 = port2;
		this.portServer = portServer;
	}

	public void writeMessage(String msg) {
		this.msg = msg;
	}

	@Override
	public void run() {

		try {

			int port = 0;
			for (int i = 0; i < 2; i++) {

				if (i == 0) {
					port = portClient1;
				} else {
					port = portClient2;
				}

				System.out.println("Cliente vai enviar mensagem para o servidor porta: " + port);
				socket = new Socket("localhost", port);
				BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

				wr.write(msg + " |port: " + portServer);
				wr.write("\n");
				wr.flush();
				wr.close();

			}

			System.out.println("\nCliente retornou como servidor na porta: " + portServer + "\n");
		} catch (

		IOException e) {
			e.printStackTrace();
		}
	}

	public String getMsg() {
		return msg;
	}

}
