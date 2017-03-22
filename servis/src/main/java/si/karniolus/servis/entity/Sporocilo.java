package si.karniolus.servis.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by alojz_000 on 21. 03. 2017.
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Sporocilo implements Serializable {
    private Status status;
    private String message;
    private String description;

    // ta konstruktor mora obvezno biti zaradi JAX-RS bindanja
    public Sporocilo() {

    }

    public Sporocilo(Status status, String message, String description) {
        this.status = status;
        this.message = message;
        this.description = description;
    }

    public Sporocilo with(Status status, String message, String description) {
        this.status = status;
        this.message = message;
        this.description = description;
        return this;
    }
}


