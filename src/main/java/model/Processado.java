package model;

import jakarta.persistence.*;
import org.eclipse.persistence.annotations.OptimisticLocking;
import org.eclipse.persistence.annotations.OptimisticLockingType;

import java.time.LocalDate;

@Entity
@Table(name = "processado")
@OptimisticLocking(type = OptimisticLockingType.VERSION_COLUMN)
public class Processado {
    //Stores ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    //Stores Longitude
    @Column(name = "longitude")
    private Double longitude;

    //Stores Latitude
    @Column(name = "latitude")
    private Double latitude;

    //Stores Dat
    @Column(name = "dat")
    private LocalDate dat;

    //Stores Gps
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "gps", nullable = false)
    private model.Gps gps;

    //Stores Rnp
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rnp")
    private RegistoNProcessado rnp;

    //Stores Vrs
    @Version
    @Column(name = "vrs")
    private Integer vrs;

    //Establishes relationship between Processado and Alarme
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "processado")
    private Alarme alarme;

    //Function whose purpose is to get the Processed's ID column
    public Integer getId() {
        return id;
    }

    //Function whose purpose is to set the Processed's ID column
    public void setId(Integer id) {
        this.id = id;
    }

    //Function whose purpose is to get the Processed's Longitude column
    public Double getLongitude() {
        return longitude;
    }

    //Function whose purpose is to set the Processed's Longitude column
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    //Function whose purpose is to get the Processed's Latitude column
    public Double getLatitude() {
        return latitude;
    }

    //Function whose purpose is to set the Processed's Latitude column
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    //Function whose purpose is to get the Processed's Dat column
    public LocalDate getDat() {
        return dat;
    }

    //Function whose purpose is to set the Processed's Dat column
    public void setDat(LocalDate dat) {
        this.dat = dat;
    }

    //Function whose purpose is to get the Processed's Gps column
    public model.Gps getGps() {
        return gps;
    }

    //Function whose purpose is to set the Processed's Gps column
    public void setGps(model.Gps gps) {
        this.gps = gps;
    }

    //Function whose purpose is to get the Processed's Rnp column
    public RegistoNProcessado getRnp() {
        return rnp;
    }

    //Function whose purpose is to set the Processed's Rnp column
    public void setRnp(RegistoNProcessado rnp) {
        this.rnp = rnp;
    }

    //Function whose purpose is to get the Processed's Vrs column
    public Integer getVrs() {
        return vrs;
    }

    //Function whose purpose is to set the Processed's Vrs column
    public void setVrs(Integer vrs) {
        this.vrs = vrs;
    }

    //Function whose purpose is to get the Processed's Alarme column
    public Alarme getAlarme() {
        return alarme;
    }

    //Function whose purpose is to set the Processed's Alarme column
    public void setAlarme(Alarme alarme) {
        this.alarme = alarme;
    }

}