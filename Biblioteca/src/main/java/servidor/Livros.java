package servidor;

import java.util.ArrayList;

public class Livros {
    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public void setLivros(ArrayList<Livro> livros) {
        this.livros = livros;
    }

    private ArrayList<Livro> livros;
}
