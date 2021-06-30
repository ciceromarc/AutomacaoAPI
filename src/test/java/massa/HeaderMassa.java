package massa;

import java.io.IOException;
import java.util.Properties;

import entities.Header;
import utils.RestUtils;

public class HeaderMassa {
    public Header header;

    Properties prop = new Properties();
    String restURI;
    String usuario;
    String senha;

    public HeaderMassa() throws IOException {
        this.prop.load(getClass().getClassLoader().getResourceAsStream("application.properties"));
        this.restURI = this.prop.getProperty("actopostura.restURI");
        this.usuario = this.prop.getProperty("actopostura.username");
        this.senha = this.prop.getProperty("actopostura.password");

        RestUtils.setUrl(this.restURI);
        RestUtils.setEndpoint("/user/login");
        RestUtils.post("{\"loginType\":\"normal\",\"username\":\""+ this.usuario +"\",\"password\":\""+ this.senha +"\",\"secretaryId\":4}");

        String token = RestUtils.getValue("data.user.authenticationToken").toString();

        this.header = new Header("Token " + token);
    }

    public Header getHeader() {
        return this.header;
    }

    public static void main(String[] args) throws IOException {
        new HeaderMassa();
    }
}
