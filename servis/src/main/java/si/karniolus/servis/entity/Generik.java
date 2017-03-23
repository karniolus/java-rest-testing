package si.karniolus.servis.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Generik<T> {
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