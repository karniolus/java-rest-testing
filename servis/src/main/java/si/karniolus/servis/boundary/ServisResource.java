package si.karniolus.servis.boundary;

import si.karniolus.servis.entity.MessageResponse;
import si.karniolus.servis.entity.Status;

import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by alojz_000 on 21. 03. 2017.
 */
@Stateless
@Produces({MediaType.APPLICATION_JSON +";charset=UTF-8"})
@Consumes({MediaType.APPLICATION_JSON +";charset=UTF-8"})
@Path("servisi")
public class ServisResource {
//    @Inject
//    MessageResponse messageResponse;

    @GET
    public String working() {
        return "Servis deluje!";
    }

    @GET
    @Path("1")
    public JsonObject test1() {
        return Json.createObjectBuilder().add("result", "To je JsonObject").build();
    }

    @GET
    @Path("2")
    public MessageResponse test2() {
        return null;
    }

    @GET
    @Path("3")
    public Response test3() {
        MessageResponse messageResponse = new MessageResponse(Status.info, "Lep pozdrav", "Vse je v redu - response", true);
        return Response.ok(messageResponse).build();
    }
}
