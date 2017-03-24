package si.karniolus.servis.boundary;

import si.karniolus.servis.entity.Generik;
import si.karniolus.servis.entity.Sporocilo;
import si.karniolus.servis.entity.Status;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alojz_000 on 21. 03. 2017.
 */
@Stateless
@Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
@Consumes({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
@Path("servisi")
public class ServisResource {
    @Inject
    Sporocilo sporocilo;

    @GET
    public String deluje() {
        return "Servis deluje!";
    }

    @GET
    @Path("1")
    public JsonObject jsonObject() {
        return Json.createObjectBuilder().add("result", 1).build();
    }

    @GET
    @Path("2")
    public Response test2() {
        return Response.serverError().entity(
                new Sporocilo(Status.error, "Napaka", "Gre za napako 500")).
                build();
    }

    @GET
    @Path("3")
    public Sporocilo test3() {
        return new Sporocilo(Status.info, "Sporočilo", "Direkt");
    }

    @GET
    @Path("4")
    public Response test4() {
        return Response.accepted().entity(
                sporocilo.with(Status.info, "Sprejeto",
                        "Sporočilo sprejeto s statusom accepted")).build();
    }

    @GET
    @Path("5")
    public Sporocilo test5() {
        return sporocilo.with(Status.warning, "Opozorilo!", "Uporabljate injecte!");
    }

    @GET
    @Path("6")
    public Generik<Sporocilo> generik() {
        return new Generik<>("Generično sporočilo z generikom", new Sporocilo(Status.info, "generično sporočilo", "T pa to pa take"));
    }

    @GET
    @Path("generikSporocilo")
    public Generik<Sporocilo> generikTipaSporocilo() {
        return new Generik<>("Generično sporočilo z generikom, ki je injectan", sporocilo.with(Status.info, "generično sporočilo", "T pa to pa take"));
    }

//    @GET
//    @Path("8")
//    public Generik generikInteger() {
//        return generik.with("generik številka", 43223);
//    }
//
//    @GET
//    @Path("9")
//    public Generik generikBoolean() {
//        return generik.with("generik boolean", Boolean.TRUE);
//    }
//
//    @GET
//    @Path("10")
//    // ta ne gre - "generik":"si.karniolus.servis.entity.Sporocilo@36d6feb6"
//    public List<Generik> listaPoljubnihGenerikov() {
//        List<Generik> result = new ArrayList<>();
//        result.add(generik.with("številka", 500));
//        result.add(generik.with("decimalke", BigDecimal.TEN));
//        result.add(generik.with("boolean", Boolean.TRUE));
//        result.add(generik.with("niz", "stringec"));
//        result.add(generik.with("objekt spročilo", sporocilo.with(Status.info, "vse", "je kul")));
//        return result;
//    }

//    @GET
//    @Path("11")
//    // to deluje
//    public Generik<Sporocilo> generikZListoObjektov() {
//        return new Generik<>("generik z listo", listaSporocil());
//    }






    private List<Sporocilo> listaSporocil() {
        List<Sporocilo> lista = new ArrayList<>();
        lista.add(new Sporocilo(Status.info, "prvo", "prvo sporočilo"));
        lista.add(new Sporocilo(Status.info, "drugo", "drugo sporočilo"));
        return lista;
    }

    @GET
    @Path("12")
    public List<Sporocilo> listaSporocilDirekt() {
        return listaSporocil();
    }

    @GET
    @Path("13")
    public Generik<Sporocilo> listaGenerik() {
        return new Generik<>("bla", listaSporocil());
    }

}
