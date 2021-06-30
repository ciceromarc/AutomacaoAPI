package entities.buscalivro;

import java.util.LinkedHashMap;

public class BuscaLivroGroup {

    private String nomelivro;

    //constructor
    public BuscaLivroGroup(String nomelivro) {
        this.nomelivro = nomelivro;
    }


    //getters and setters
    public String getNomelivro() {
        return nomelivro;
    }

    public void setNomelivro(String nomelivro) {
        this.nomelivro = nomelivro;
    }
}

