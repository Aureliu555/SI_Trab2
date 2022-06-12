package model;

import jakarta.persistence.*;

@Entity
@Table(name = "zonaverde")
public class ZonaVerde {
    //Stores ID
    @EmbeddedId
    private ZonaverdeId id;

    //Stores Raio
    @Column(name = "raio", nullable = false)
    private Double raio;

    //Stores Matricula
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "matricula")
    private Veiculo matricula;

    //Stores Vrs
    @Version
    @Column(name = "vrs")
    private Integer vrs;

    //Function whose purpose is to get the GreenZone's ID column
    public ZonaverdeId getId() {
        return id;
    }

    //Function whose purpose is to set the GreenZone's ID column
    public void setId(ZonaverdeId id) {
        this.id = id;
    }

    //Function whose purpose is to get the GreenZone's Raio column
    public Double getRaio() {
        return raio;
    }

    //Function whose purpose is to set the GreenZone's Raio column
    public void setRaio(Double raio) {
        this.raio = raio;
    }

    //Function whose purpose is to get the GreenZone's Matricula column
    public Veiculo getMatricula() {
        return matricula;
    }

    //Function whose purpose is to set the GreenZone's Matricula column
    public void setMatricula(Veiculo matricula) {
        this.matricula = matricula;
    }

    //Function whose purpose is to get the GreenZone's Vrs column
    public Integer getVrs() {
        return vrs;
    }

    //Function whose purpose is to set the GreenZone's Vrs column
    public void setVrs(Integer vrs) {
        this.vrs = vrs;
    }

}