package servidor;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class JsonUtil {
    private static final String FILE_PATH = "src/main/resources/livros.json";
    private static final Gson gson = new Gson();
//    private static final Type LIVRO_LIST_TYPE = new TypeToken<List<Livro>>(){}.getType();

    public static Livros carregarLivros() throws IOException {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            return gson.fromJson(reader, Livros.class);
        }
    }

    public static void salvarLivros(Livros livros) throws IOException {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(livros, writer);
        }
    }




}

