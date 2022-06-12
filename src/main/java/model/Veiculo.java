package model;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "veiculo")
public class Veiculo {
    //Stores ID
    @Id
    @Column(name = "matricula", nullable = false, length = 10)
    private String id;
    //Stores Nif

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "nif", nullable = false)
    private Cliente nif;

    //Stores Nomecondutor
    @Column(name = "nomecondutor", nullable = false, length = 150)
    private String nomecondutor;

    //Stores Telefone
    @Column(name = "telefone", length = 10)
    private String telefone;

    //Stores Numalarmes
    @Column(name = "numalarmes")
    private Integer numalarmes;

    //Stores Gps
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gps")
    private model.Gps gps;

    //Stores Vrs
    @Version
    @Column(name = "vrs")
    private Integer vrs;

    //Establishes a relationship between Veiculo and Zonaverde
    @OneToMany(mappedBy = "matricula")
    private Set<ZonaVerde> zonaVerdes = new LinkedHashSet<>();

    //Establishes a relationship between Veiculo and Gps
    @OneToMany(mappedBy = "matricula")
    private Set<model.Gps> matricula = new LinkedHashSet<>();

    //Function whose purpose is to get the Vehicle's ID column
    public String getId() {
        return id;
    }

    //Function whose purpose is to set the Vehicle's ID column
    public void setId(String id) {
        this.id = id;
    }

    //Function whose purpose is to get the Vehicle's Nif column
    public Cliente getNif() {
        return nif;
    }

    //Function whose purpose is to set the Vehicle's Nif column
    public void setNif(Cliente nif) {
        this.nif = nif;
    }

    //Function whose purpose is to get the Vehicle's Nomecondutor column
    public String getNomecondutor() {
        return nomecondutor;
    }

    //Function whose purpose is to set the Vehicle's Nomecondutor column
    public void setNomecondutor(String nomecondutor) {
        this.nomecondutor = nomecondutor;
    }

    //Function whose purpose is to get the Vehicle's Telefone column
    public String getTelefone() {
        return telefone;
    }

    //Function whose purpose is to set the Vehicle's Telefone column
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    //Function whose purpose is to get the Vehicle's Numalarmes column
    public Integer getNumalarmes() {
        return numalarmes;
    }

    //Function whose purpose is to set the Vehicle's Numalarmes column
    public void setNumalarmes(Integer numalarmes) {
        this.numalarmes = numalarmes;
    }

    //Function whose purpose is to get the Vehicle's Gps column
    public model.Gps getGps() {
        return gps;
    }

    //Function whose purpose is to set the Vehicle's Gps column
    public void setGps(model.Gps gps) {
        this.gps = gps;
    }

    //Function whose purpose is to get the Vehicle's Vrs column
    public Integer getVrs() {
        return vrs;
    }

    //Function whose purpose is to set the Vehicle's Vrs column
    public void setVrs(Integer vrs) {
        this.vrs = vrs;
    }

    //Function whose purpose is to get the Vehicle's Zonaverde column
    public Set<ZonaVerde> getZonaverdes() {
        return zonaVerdes;
    }

    //Function whose purpose is to set the Vehicle's Zonaverde column
    public void setZonaverdes(Set<ZonaVerde> zonaVerdes) {
        this.zonaVerdes = zonaVerdes;
    }

    //Function whose purpose is to get the Vehicle's Matricula column
    public Set<model.Gps> getMatricula() {
        return matricula;
    }

    //Function whose purpose is to set the Vehicle's Matricula column
    public void setMatricula(Set<model.Gps> matricula) {
        this.matricula = matricula;
    }

}