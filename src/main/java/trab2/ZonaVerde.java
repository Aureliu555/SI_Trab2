package trab2;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "zona_verde")
public class ZonaVerde {
    @Id
    @Column(name = "id_zona_verde", nullable = false, length = 50)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "matricula")
    private Veiculo matricula;

    @Column(name = "raio", nullable = false)
    private Integer raio;

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

    public Veiculo getMatricula() {
        return matricula;
    }

    public void setMatricula(Veiculo matricula) {
        this.matricula = matricula;
    }

    public Integer getRaio() {
        return raio;
    }

    public void setRaio(Integer raio) {
        this.raio = raio;
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