package si.karniolus.servis.boundary;

import si.karniolus.servis.entity.Message;
import si.karniolus.servis.entity.MessageList;
import si.karniolus.servis.entity.Rezultat;

import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        Message<Rezultat> message = new Message<>(info, "Poljubni razred - rezultat", "...", new Rezultat(data));
        return Response.ok(new GenericEntity<Message<Rezultat>>(message) {
        }).build();
    }


    private List<Rezultat> getListaRezultatov() {
        List<Rezultat> list = new ArrayList<>();
        list.add(new Rezultat("prvi"));
        list.add(new Rezultat("drugi"));
        list.add(new Rezultat("tretji"));
        return list;
    }

    @GET
    @Path("rezultat/seznam")
    public Response seznamRezultatov() {
        MessageList<Rezultat> message = new MessageList<>(MessageList.Status.info, "Poljubni razred - lista s parametrom", "...", getListaRezultatov());
        return Response.ok(new GenericEntity<MessageList<Rezultat>>(message) {
        }).build();
    }

    @GET
    @Path("rezultat/seznam/{prvi}")
    public Response seznamRezultatovParam(@PathParam("prvi") String prvi) {
        MessageList<Rezultat> message = new MessageList<>(MessageList.Status.info, "Poljubni razred - lista s parametrom", "...", Arrays.asList(new Rezultat(prvi), new Rezultat("drugi"), new Rezultat("tretji")));
        return Response.ok(new GenericEntity<MessageList<Rezultat>>(message) {
        }).build();
    }
}
