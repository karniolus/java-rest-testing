package si.karniolus.servis.boundary;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

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
        MatcherAssert.assertThat(response.getStatusInfo(), Matchers.is(Response.Status.OK));
        String rezultat = response.readEntity(String.class);
        LOG.info("Rezultat klica za delovanje: "+ rezultat);
    }

    @Test
    public void jsonObject() throws Exception {
        JsonObject jsonObject = target.path("1").request().get(JsonObject.class);
        LOG.info("Rezultat klica za JSON objekt: "+ jsonObject);
    }

    @Test
    public void generikSporociloJSON(){
        Response response = target.path("generikSporocilo").request().get();
        MatcherAssert.assertThat(response.getStatusInfo(), Matchers.is(Response.Status.OK));
        JsonObject jsonObject = response.readEntity(JsonObject.class);
        LOG.info(jsonObject.toString());
    }

//    @Test
//    public void generikSporociloPOJO(){
//        Response response = target.path("generikSporocilo").request().get();
//        MatcherAssert.assertThat(response.getStatusInfo(), Matchers.is(Response.Status.OK));
//        Generik<Sporocilo> sporociloGenerik = response.readEntity(Generik.class);
//        LOG.info(sporociloGenerik.toString());
//    }

    @Test
    public void generikSporociloPOJOgenerik()  {
        Response response = target.path("generikSporocilo").request().get();
        MatcherAssert.assertThat(response.getStatusInfo(), Matchers.is(Response.Status.OK));
        Generik<Sporocilo> sporociloGenerik = response.readEntity(new GenericType<Generik<Sporocilo>>() {
        });
        LOG.info(sporociloGenerik.toString());
    }
}
