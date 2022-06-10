package model;

import jakarta.persistence.*;

@Entity
@Table(name = "zonaverde")
public class ZonaVerde {
    @EmbeddedId
    private ZonaverdeId id;

    @Column(name = "raio", nullable = false)
    private Double raio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "matricula")
    private Veiculo matricula;

    @Version
    @Column(name = "vrs")
    private Integer vrs;

    public ZonaverdeId getId() {
        return id;
    }

    public void setId(ZonaverdeId id) {
        this.id = id;
    }

    public Double getRaio() {
        return raio;
    }

    public void setRaio(Double raio) {
        this.raio = raio;
    }

    public Veiculo getMatricula() {
        return matricula;
    }

    public void setMatricula(Veiculo matricula) {
        this.matricula = matricula;
    }

    public Integer getVrs() {
        return vrs;
    }

    public void setVrs(Integer vrs) {
        this.vrs = vrs;
    }

}