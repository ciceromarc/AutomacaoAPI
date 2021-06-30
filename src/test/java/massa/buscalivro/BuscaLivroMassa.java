package massa.buscalivro;

import entities.buscalivro.BuscaLivroGroup;


public class BuscaLivroMassa {
    public static BuscaLivroGroup buscalivrogroup = new BuscaLivroGroup("pipas");
    public static String url = "http://www.lojaexemplodelivros.com.br/";
    public static String endpoint = "catalogsearch/result/?q=";
    public static String id;

    public static BuscaLivroGroup geraMassa() {
        return buscalivrogroup;
    }

}
