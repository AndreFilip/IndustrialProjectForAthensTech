package gr.athtech.industrial.codehub.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author George Lalas
 */
@Entity
@Table(name="country")
public class Country implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;
    @Column(name="isoCode", nullable = false)
    private String isoCode;
    @Column(name="nameCapital", nullable = false)
    private String nameCapital;
    @Column(name="nameView", nullable = false)
    private String nameView;
    @Column(name="isoCode3")
    private String isoCode3;
    @Column(name="numCode")
    private String numCode;
    @Column(name="phoneCode", nullable = false)
    private String phoneCode;

    public Country() {
    }

    public String getIsoCode() {
        return isoCode;
    }

    public String getNameCapital() {
        return nameCapital;
    }

    public String getNameView() {
        return nameView;
    }

    public String getIsoCode3() {
        return isoCode3;
    }

    public String getNumCode() {
        return numCode;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", isoCode='" + isoCode + '\'' +
                ", nameCapital='" + nameCapital + '\'' +
                ", nameView='" + nameView + '\'' +
                ", isoCode3='" + isoCode3 + '\'' +
                ", numCode='" + numCode + '\'' +
                ", phoneCode='" + phoneCode + '\'' +
                '}';
    }
}
