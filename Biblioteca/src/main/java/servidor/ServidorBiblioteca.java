package servidor;

import com.google.gson.Gson;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class ServidorBiblioteca {

    private static final int PORT = 12345;
    private Biblioteca biblioteca;

    public ServidorBiblioteca() throws IOException {
        biblioteca = new Biblioteca();
    }

    public static void main(String[] args) {
        try {
            ServidorBiblioteca servidor = new ServidorBiblioteca();
            servidor.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Servidor rodando na porta " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Cliente conectado: " + clientSocket.getInetAddress().getHostAddress());

            new Thread(() -> {
                try {
                    handleClient(clientSocket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    private void handleClient(Socket clientSocket) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        String request;
        while ((request = in.readLine()) != null) {
            String response = processRequest(request);
            out.println(response);
        }

        clientSocket.close();
    }

    private String processRequest(String request) {
        String[] parts = request.split(";");
        String command = parts[0];

        switch (command) {
            case "LISTAR":
                Livros livros = biblioteca.listarLivros();
                return new Gson().toJson(livros);

            case "CADASTRAR":
                if (parts.length == 5) {
                    Livro livro = new Livro(parts[1], parts[2], parts[3], Integer.parseInt(parts[4]));
                    if (biblioteca.cadastrarLivro(livro)) {
                        return "Livro cadastrado com sucesso.";
                    }
                }
                return "Não foi possível cadastrar o livro.";

            case "ALUGAR":
                if (parts.length == 2 && biblioteca.alugarLivro(parts[1])) {
                    return "Livro alugado com sucesso.";
                }
                return "Não foi possível alugar o livro.";

            case "DEVOLVER":
                if (parts.length == 2 && biblioteca.devolverLivro(parts[1])) {
                    return "Livro devolvido com sucesso.";
                }
                return "Não foi possível devolver o livro.";

            default:
                return "Comando desconhecido ou errado.(tente novamente).";
        }
    }
}
