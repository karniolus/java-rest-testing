package si.karniolus.servis.entity;

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
public class Message<T> extends AbstractMessage implements Serializable {
    public enum Status {info, warning, error}

    private Status status;
    private String message;
    private String description;
    private T data;

    public Message() {
    }

    public Message(Status status, String message, String description, T data) {
        this.status = status;
        this.message = message;
        this.description = description;
        this.data = data;
    }

    public Message(Status status, String message, String description, List<T> dataList) {
        this.status = status;
        this.message = message;
        this.description = description;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}