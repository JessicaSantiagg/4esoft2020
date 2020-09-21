package trabalho3Bimestre;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import aula20200803.introducaoIO.EchoClient;

public class Client {
	private static final String SERVER_ADDRESS = "localhost";
	private static final int PORT = 8080;

	public static void main(String[] args) throws Exception {
		Client client = new Client();
		client.doIt();
	}

	private void doIt() throws Exception {
		InputStream consoleInput = System.in;
		OutputStream consoleOutput = System.out;
		
		String comando = "";
		Scanner scannerConsole = new Scanner(consoleInput);
		int cont = 1;
		while (!comando.equalsIgnoreCase("sair")) {
			comando = scannerConsole.nextLine();
			String response = handleServerCommunication(comando);
			System.out.println(response);
		}
		System.out.println("Saiu.");
	}

	private String handleServerCommunication(String comando) throws UnknownHostException, IOException {
		Socket connection = new Socket(SERVER_ADDRESS, PORT);			
		Scanner serverInput = new Scanner(connection.getInputStream());
		PrintWriter serverOutput = new PrintWriter(connection.getOutputStream());
		serverOutput.println(comando);
		serverOutput.flush();			
		String response = serverInput.nextLine();
		connection.close();
		return response;
	}
}
