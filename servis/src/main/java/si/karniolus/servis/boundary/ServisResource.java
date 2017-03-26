package si.karniolus.servis.boundary;

import si.karniolus.servis.entity.Message;
import si.karniolus.servis.entity.Rezultat;

import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static si.karniolus.servis.entity.Message.Status.info;

/**
 * Created by alojz_000 on 21. 03. 2017.
 */
@Stateless
@Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
@Consumes({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
@Path("servisi")
public class ServisResource {
    @GET
    public String deluje() {
        return "Servis deluje";
    }

    @GET
    @Path("integer/{data}")
    public Response integerMessage(@PathParam("data") Integer data) {
        Message<Integer> message = new Message<>(info, "Celo število",
                "Sporočilo celoštevilčnega tipa", data);
        GenericEntity<Message<Integer>> genericMessage = new GenericEntity<Message<Integer>>(message) {
        };
        return Response.ok(genericMessage).build();
    }

    @GET
    @Path("rezultat/{data}")
    public Response rezultatMessage(@PathParam("data") String data) {
        Message<Rezultat> message = new Message<>(info, "Poljubni razred", "...", new Rezultat(data));
        return Response.ok(new GenericEntity<Message<Rezultat>>(message) {
        }).build();
    }


}
