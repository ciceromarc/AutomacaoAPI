package steps;

import entities.Header;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Entao;
import massa.HeaderMassa;
import massa.buscalivro.BuscaLivroMassa;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import utils.RestUtils;

import java.io.IOException;

public class BuscaLivroSteps {
    String url;
    String endpoint;
    Header header;


    @Dado("que tenho um payload valido do Busca Livro")
    public void queTenhoUmPayloadValidoDoBuscaLivro() throws IOException {
        url = BuscaLivroMassa.url;
        endpoint = BuscaLivroMassa.endpoint;
        header = new HeaderMassa().getHeader();
        RestUtils.setUrl(url);
        RestUtils.setEndpoint(endpoint);
    }



    @Quando("realizo uma requisicao get no Busca livro com nome do livro {string}")
    public void realizoUmaRequisicaoGetNoBuscaLivroComNomeDoLivro(String nomelivro) {
        RestUtils.setEndpoint(endpoint+nomelivro);
        RestUtils.get(header.get());
        RestUtils.setEndpoint(endpoint);
//        System.out.println("Retorno do GET: "+RestUtils.getBody());
    }
    @Entao("valido a requisicao com sucesso {int}")
    public void validoOStatusCode(Integer status) {
        Integer validaretorno = RestUtils.getBodytext();
        System.out.println("Este é o validastatus: "+validaretorno);
        Assert.assertEquals(validaretorno, status);

    }


}

