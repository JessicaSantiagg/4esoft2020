package trabalho3Bimestre;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class Server {
	public static void main(String[] args) throws Exception {
		
		System.out.println("Iniciando Servidor...");
		ServerSocket servidor = new ServerSocket(8080);
		System.out.println("Servidor ouvindo a porta 8080, aguardando conexão");
		
		while (true) {
			Socket socket  = servidor.accept();
			System.out.println("Conexão estabelecida");
			
			Scanner input = new Scanner(socket.getInputStream());
			PrintWriter output = new PrintWriter(socket.getOutputStream());
			String request = input.nextLine();
			
			String response = "";
			if(request.equalsIgnoreCase("ping")) {
				response = ("pong");
			}else {
				response = ("it's not ping!");
			}
			output.println(response);
			output.flush();
		}
	}
}
