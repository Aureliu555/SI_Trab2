package model;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @Column(name = "nif", nullable = false)
    private Integer id;

    @Column(name = "nome", nullable = false, length = 150)
    private String nome;

    @Column(name = "telefone", nullable = false, length = 10)
    private String telefone;

    @Column(name = "morada", nullable = false, length = 150)
    private String morada;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cpnif")
    private Clienteparticular cpnif;

    @Version
    @Column(name = "vrs")
    private Integer vrs;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "cliente")
    private Clienteparticular clienteparticular;

    @OneToMany(mappedBy = "nif")
    private Set<Veiculo> veiculos = new LinkedHashSet<>();

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "cliente")
    private Clienteinstitucional clienteinstitucional;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public Clienteparticular getCpnif() {
        return cpnif;
    }

    public void setCpnif(Clienteparticular cpnif) {
        this.cpnif = cpnif;
    }

    public Integer getVrs() {
        return vrs;
    }

    public void setVrs(Integer vrs) {
        this.vrs = vrs;
    }

    public Clienteparticular getClienteparticular() {
        return clienteparticular;
    }

    public void setClienteparticular(Clienteparticular clienteparticular) {
        this.clienteparticular = clienteparticular;
    }

    public Set<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(Set<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public Clienteinstitucional getClienteinstitucional() {
        return clienteinstitucional;
    }

    public void setClienteinstitucional(Clienteinstitucional clienteinstitucional) {
        this.clienteinstitucional = clienteinstitucional;
    }

}