package si.karniolus.servis.boundary;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Generik<T> implements Serializable {
    private String message;
    private T result;
    private List<T> resultList;

    public Generik() {
    }

    public Generik(String message, T result) {
        this.message = message;
        this.result = result;
    }

    public Generik(String message, List<T> resultList) {
        this.message = message;
        this.resultList = resultList;
    }
}