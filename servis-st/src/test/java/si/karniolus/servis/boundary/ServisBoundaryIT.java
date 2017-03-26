package si.karniolus.servis.boundary;

import org.junit.Test;

import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

import static javax.ws.rs.core.Response.Status.OK;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by alojz_000 on 24. 03. 2017.
 */

public class ServisBoundaryIT {
    private final Client client = ClientBuilder.newClient();
    private final WebTarget target = client.target("http://localhost:8080/servis/api/servisi");
    private final Logger LOG = Logger.getAnonymousLogger();

    @Test
    public void deluje() {
        Response response = target.request().get();
        assertThat(response.getStatusInfo(), is(OK));
        String rezultat = response.readEntity(String.class);
        LOG.info("Rezultat klica za delovanje: " + rezultat);
    }

    @Test
    public void integerResponseJson() {
        Integer input = 12345;
        Response response = target.path("integer/" + input).request().get();
        assertThat(response.getStatusInfo(), is(OK));
        JsonObject result = response.readEntity(JsonObject.class);
        assertThat(result.getJsonObject("data").getInt("value"), is(input));
    }


    @Test
    // ta ne deluje!
    public void integerResponse() {
        Integer input = 12345;
        Response response = target.path("integer/" + input).request().get();
        assertThat(response.getStatusInfo(), is(OK));
        Message<Integer> result = response.readEntity(new GenericType<Message<Integer>>() {
        });
    }

    @Test
    public void rezultatResponse() {
        String input = "bla";
        Response response = target.path("rezultat/" + input).request().get();
        assertThat(response.getStatusInfo(), is(OK));
        Message<Rezultat> result = response.readEntity(new GenericType<Message<Rezultat>>() {
        });
        assertThat(result.getData().getRezultat(), is(input));
    }
}
