package cliente;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClienteBiblioteca {

    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Cliente conectado ao servidor\n\n" +
                    "Explicação dos comandos:\n" +
                    "LISTAR\n" +
                    "CADASTRAR;Nome do autor;Título do livro;Gênero do livro;Número de exemplares do livro\n" +
                    "ALUGAR;Título do livro\n" +
                    "DEVOLVER;Título do livro\n" +
                    "SAIR\n");

            String command;
            while (true) {
                System.out.println("Digite um comando (LISTAR, CADASTRAR, ALUGAR, DEVOLVER, SAIR):");
                command = scanner.nextLine();

                if (command.equalsIgnoreCase("SAIR")) {
                    break;
                }

                out.println(command);
                String response = in.readLine();
                System.out.println("Resposta do servidor: " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
