package model;

import jakarta.persistence.*;
import org.eclipse.persistence.annotations.OptimisticLocking;
import org.eclipse.persistence.annotations.OptimisticLockingType;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "registonprocessado")
@OptimisticLocking(type = OptimisticLockingType.VERSION_COLUMN)
public class RegistoNProcessado {
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
    @Column(name = "gps")
    private Integer gps;

    //Stores Vrs
    @Version
    @Column(name = "vrs")
    private Integer vrs;

    //Establishes a relationship between Registonprocessado and Invalido
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "registonprocessado")
    private Invalido invalido;

    //Establishes a relationship between Registonprocessado and Processado
    @OneToMany(mappedBy = "rnp")
    private Set<Processado> processados = new LinkedHashSet<>();

    //Function whose purpose is to get the NProcessedRegister's Id column
    public Integer getId() {
        return id;
    }

    //Function whose purpose is to set the NProcessedRegister's Id column
    public void setId(Integer id) {
        this.id = id;
    }

    //Function whose purpose is to get the NProcessedRegister's Longitude column
    public Double getLongitude() {
        return longitude;
    }

    //Function whose purpose is to set the NProcessedRegister's Longitude column
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    //Function whose purpose is to get the NProcessedRegister's Latitude column
    public Double getLatitude() {
        return latitude;
    }

    //Function whose purpose is to set the NProcessedRegister's Latitude column
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    //Function whose purpose is to get the NProcessedRegister's Dat column
    public LocalDate getDat() {
        return dat;
    }

    //Function whose purpose is to set the NProcessedRegister's Dat column
    public void setDat(LocalDate dat) {
        this.dat = dat;
    }

    //Function whose purpose is to get the NProcessedRegister's Gps column
    public Integer getGps() {
        return gps;
    }

    //Function whose purpose is to set the NProcessedRegister's Gps column
    public void setGps(Integer gps) {
        this.gps = gps;
    }

    //Function whose purpose is to get the NProcessedRegister's Vrs column
    public Integer getVrs() {
        return vrs;
    }

    //Function whose purpose is to set the NProcessedRegister's Vrs column
    public void setVrs(Integer vrs) {
        this.vrs = vrs;
    }

    //Function whose purpose is to get the NProcessedRegister's Invalido column
    public Invalido getInvalido() {
        return invalido;
    }

    //Function whose purpose is to set the NProcessedRegister's Invalido column
    public void setInvalido(Invalido invalido) {
        this.invalido = invalido;
    }

    //Function whose purpose is to get the NProcessedRegister's Processado column
    public Set<Processado> getProcessados() {
        return processados;
    }

    //Function whose purpose is to set the NProcessedRegister's Processado column
    public void setProcessados(Set<Processado> processados) {
        this.processados = processados;
    }

}