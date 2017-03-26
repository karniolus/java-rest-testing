package si.karniolus.servis.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by alojz_000 on 26. 03. 2017.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Rezultat implements Serializable {
    private String rezultat;

    public Rezultat() {
    }

    public Rezultat(String rezultat) {
        this.rezultat = rezultat;
    }

    public String getRezultat() {
        return rezultat;
    }

    public void setRezultat(String rezultat) {
        this.rezultat = rezultat;
    }
}
