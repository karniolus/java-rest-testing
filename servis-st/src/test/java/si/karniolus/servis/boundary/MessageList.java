package si.karniolus.servis.boundary;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/*
* Sporočilo v obliki:
* - status - stanje sporočila (info,warning,error)
* - message - sporočilo
* - description - opis sporočila
* - data - podatki v poljubni obliki
* */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageList<T> implements Serializable {
    public enum Status {info, warning, error}
    private Status status;
    private String message;
    private String description;
    private List<T> data;

    public MessageList() {
    }

    public MessageList(Status status, String message, String description, List<T> data) {
        this.status = status;
        this.message = message;
        this.description = description;
        this.data = data;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}