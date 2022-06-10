package model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "processado")
public class Processado {
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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "gps", nullable = false)
    private model.Gps gps;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rnp")
    private RegistoNProcessado rnp;

    @Version
    @Column(name = "vrs")
    private Integer vrs;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "processado")
    private Alarme alarme;

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

    public model.Gps getGps() {
        return gps;
    }

    public void setGps(model.Gps gps) {
        this.gps = gps;
    }

    public RegistoNProcessado getRnp() {
        return rnp;
    }

    public void setRnp(RegistoNProcessado rnp) {
        this.rnp = rnp;
    }

    public Integer getVrs() {
        return vrs;
    }

    public void setVrs(Integer vrs) {
        this.vrs = vrs;
    }

    public Alarme getAlarme() {
        return alarme;
    }

    public void setAlarme(Alarme alarme) {
        this.alarme = alarme;
    }

}