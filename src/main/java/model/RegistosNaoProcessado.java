package model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "registos_nao_processados")
public class RegistosNaoProcessado {
    @Id
    @Column(name = "id_gps", nullable = false, length = 50)
    private String id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_gps", nullable = false)
    private EquipamentoGp equipamentoGps;

    @Column(name = "latitude", precision = 8, scale = 5)
    private BigDecimal latitude;

    @Column(name = "longitude", precision = 8, scale = 5)
    private BigDecimal longitude;

    @Column(name = "registo_data")
    private LocalDate registoData;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EquipamentoGp getEquipamentoGps() {
        return equipamentoGps;
    }

    public void setEquipamentoGps(EquipamentoGp equipamentoGps) {
        this.equipamentoGps = equipamentoGps;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public LocalDate getRegistoData() {
        return registoData;
    }

    public void setRegistoData(LocalDate registoData) {
        this.registoData = registoData;
    }

}