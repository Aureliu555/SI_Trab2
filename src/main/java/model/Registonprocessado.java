package model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "registonprocessado")
public class Registonprocessado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "dat")
    private LocalDate dat;

    @Column(name = "gps")
    private Integer gps;

    @Version
    @Column(name = "vrs")
    private Integer vrs;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "registonprocessado")
    private Invalido invalido;

    @OneToMany(mappedBy = "rnp")
    private Set<Processado> processados = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public LocalDate getDat() {
        return dat;
    }

    public void setDat(LocalDate dat) {
        this.dat = dat;
    }

    public Integer getGps() {
        return gps;
    }

    public void setGps(Integer gps) {
        this.gps = gps;
    }

    public Integer getVrs() {
        return vrs;
    }

    public void setVrs(Integer vrs) {
        this.vrs = vrs;
    }

    public Invalido getInvalido() {
        return invalido;
    }

    public void setInvalido(Invalido invalido) {
        this.invalido = invalido;
    }

    public Set<Processado> getProcessados() {
        return processados;
    }

    public void setProcessados(Set<Processado> processados) {
        this.processados = processados;
    }

}