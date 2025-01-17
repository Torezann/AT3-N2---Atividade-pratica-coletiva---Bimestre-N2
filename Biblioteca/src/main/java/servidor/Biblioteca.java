package servidor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Biblioteca {
    private Livros livros;

    public Biblioteca() throws IOException {
        this.livros = JsonUtil.carregarLivros();
    }

    public Livros listarLivros() {
        return livros;
    }

    public boolean cadastrarLivro(Livro livro) {
        livros.getLivros().add(livro);
        salvar();
        return true;
    }

    public boolean alugarLivro(String titulo) {
        Optional<Livro> livroOpt = livros.getLivros().stream().filter(l -> l.getTitulo().equalsIgnoreCase(titulo)).findFirst();
        if (livroOpt.isPresent() && livroOpt.get().getExemplares() > 0) {
            livroOpt.get().setExemplares(livroOpt.get().getExemplares() - 1);
            salvar();
            return true;
        }
        return false;
    }

    public boolean devolverLivro(String titulo) {
        Optional<Livro> livroOpt = livros.getLivros().stream().filter(l -> l.getTitulo().equalsIgnoreCase(titulo)).findFirst();
        if (livroOpt.isPresent()) {
            livroOpt.get().setExemplares(livroOpt.get().getExemplares() + 1);
            salvar();
            return true;
        }
        return false;
    }

    private void salvar() {
        try {
            JsonUtil.salvarLivros((Livros) livros);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
