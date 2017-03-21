package si.karniolus.servis.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by alojz_000 on 21. 03. 2017.
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageResponse {
    private Status status;
    private String message;
    private String description;
    private Object result;

    public MessageResponse(Status status, String message, String description, Object result) {
        this.status = status;
        this.message = message;
        this.description = description;
        this.result = result;
    }

    public MessageResponse with(Status status, String message, String description, Object result) {
        this.status = status;
        this.message = message;
        this.description = description;
        this.result = result;

        return this;
    }
}
