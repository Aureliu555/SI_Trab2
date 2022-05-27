package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "equipamento_gps")
public class EquipamentoGp {
    @Id
    @Column(name = "id", nullable = false, length = 50)
    private String id;

    @Column(name = "marca_temporal", nullable = false)
    private Instant marcaTemporal;

    @Column(name = "latitude", nullable = false, precision = 8, scale = 5)
    private BigDecimal latitude;

    @Column(name = "longitude", nullable = false, precision = 8, scale = 5)
    private BigDecimal longitude;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instant getMarcaTemporal() {
        return marcaTemporal;
    }

    public void setMarcaTemporal(Instant marcaTemporal) {
        this.marcaTemporal = marcaTemporal;
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

}