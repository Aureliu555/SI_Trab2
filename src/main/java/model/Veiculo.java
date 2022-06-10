package model;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "veiculo")
public class Veiculo {
    @Id
    @Column(name = "matricula", nullable = false, length = 10)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "nif", nullable = false)
    private Cliente nif;

    @Column(name = "nomecondutor", nullable = false, length = 150)
    private String nomecondutor;

    @Column(name = "telefone", length = 10)
    private String telefone;

    @Column(name = "numalarmes")
    private Integer numalarmes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gps")
    private model.Gps gps;

    @Version
    @Column(name = "vrs")
    private Integer vrs;

    @OneToMany(mappedBy = "matricula")
    private Set<ZonaVerde> zonaVerdes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "matricula")
    private Set<model.Gps> matricula = new LinkedHashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cliente getNif() {
        return nif;
    }

    public void setNif(Cliente nif) {
        this.nif = nif;
    }

    public String getNomecondutor() {
        return nomecondutor;
    }

    public void setNomecondutor(String nomecondutor) {
        this.nomecondutor = nomecondutor;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getNumalarmes() {
        return numalarmes;
    }

    public void setNumalarmes(Integer numalarmes) {
        this.numalarmes = numalarmes;
    }

    public model.Gps getGps() {
        return gps;
    }

    public void setGps(model.Gps gps) {
        this.gps = gps;
    }

    public Integer getVrs() {
        return vrs;
    }

    public void setVrs(Integer vrs) {
        this.vrs = vrs;
    }

    public Set<ZonaVerde> getZonaverdes() {
        return zonaVerdes;
    }

    public void setZonaverdes(Set<ZonaVerde> zonaVerdes) {
        this.zonaVerdes = zonaVerdes;
    }

    public Set<model.Gps> getMatricula() {
        return matricula;
    }

    public void setMatricula(Set<model.Gps> matricula) {
        this.matricula = matricula;
    }

}