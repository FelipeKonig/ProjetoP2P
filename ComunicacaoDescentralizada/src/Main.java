import java.io.FileReader;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Properties;
import java.util.Scanner;

public class Main {

	private static Scanner scanner;
	private static int portClient, portClient2, portServer;

	public static void main(String args[]) throws UnknownHostException, IOException {

		FileReader file;
		Properties prop = new Properties();
		try {
			file = new FileReader(args[0]);
			prop.load(file);

		} catch (Exception e) {
			e.printStackTrace();
		}

		createProp(prop);

		Client client = new Client(portClient, portClient2, portServer);
		Server server = new Server(portServer, client);

		server.start();

		while (true) {
			scanner = new Scanner(System.in);
			String newMsg = scanner.next();
			client.writeMessage(newMsg);

			System.out.println("\nServidor se tornou cliente \n");
			client.run();
		}

	}

	public static void createProp(Properties prop) {
		int id = Integer.valueOf(prop.getProperty("id"));
		String node = prop.getProperty("node");
		String ip = prop.getProperty("ip");
		portServer = Integer.valueOf(prop.getProperty("port"));
		portClient = Integer.valueOf(prop.getProperty("next_door"));
		portClient2 = Integer.valueOf(prop.getProperty("next_door2"));

		System.out.println("id:" + id);
		System.out.println("node:" + node);
		System.out.println("ip:" + ip);
		System.out.println("port:" + portServer);
		System.out.println("porta do cliente1:" + portClient);
		System.out.println("porta do cliente2:" + portClient2);
	}
}
