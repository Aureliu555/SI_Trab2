package model;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "cliente")
public class Cliente {
    //Stores ID
    @Id
    @Column(name = "nif", nullable = false)
    private Integer id;

    //Stores Nome
    @Column(name = "nome", nullable = false, length = 150)
    private String nome;

    //Stores telefone
    @Column(name = "telefone", nullable = false, length = 10)
    private String telefone;

    //Stores morada
    @Column(name = "morada", nullable = false, length = 150)
    private String morada;

    //Stores Cpnif
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cpnif")
    private ClienteParticular cpnif;

    //Stores Vrs
    @Version
    @Column(name = "vrs")
    private Integer vrs;

    //Establishes relationship between Cliente and ClienteParticular
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "cliente")
    private ClienteParticular clienteparticular;

    //Establishes relationship between Cliente and Veiculo
    @OneToMany(mappedBy = "nif")
    private Set<Veiculo> veiculos = new LinkedHashSet<>();

    //Establishes relationship between Cliente and ClienteInstitucional
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "cliente")
    private ClienteInstitucional clienteinstitucional;

    //Function whose purpose is to get the Client's ID column
    public Integer getId() {
        return id;
    }

    //Function whose purpose is to set the Client's ID column
    public void setId(Integer id) {
        this.id = id;
    }

    //Function whose purpose is to get the Client's Nome column
    public String getNome() {
        return nome;
    }

    //Function whose purpose is to set the Client's ID column
    public void setNome(String nome) {
        this.nome = nome;
    }

    //Function whose purpose is to get the Client's Telefone column
    public String getTelefone() {
        return telefone;
    }

    //Function whose purpose is to set the Client's Telefone column
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    //Function whose purpose is to get the Client's Morada column
    public String getMorada() {
        return morada;
    }

    //Function whose purpose is to set the Client's Morada column
    public void setMorada(String morada) {
        this.morada = morada;
    }

    //Function whose purpose is to get the Client's Cpnif column
    public ClienteParticular getCpnif() {
        return cpnif;
    }

    //Function whose purpose is to set the Client's Cpnif column
    public void setCpnif(ClienteParticular cpnif) {
        this.cpnif = cpnif;
    }

    //Function whose purpose is to get the Client's Vrs column
    public Integer getVrs() {
        return vrs;
    }

    //Function whose purpose is to set the Client's Vrs column
    public void setVrs(Integer vrs) {
        this.vrs = vrs;
    }

    //Function whose purpose is to get the Client's Clienteparticular column
    public ClienteParticular getClienteparticular() {
        return clienteparticular;
    }

    //Function whose purpose is to set the Client's Clienteparticular column
    public void setClienteparticular(ClienteParticular clienteparticular) {
        this.clienteparticular = clienteparticular;
    }

    //Function whose purpose is to get the Client's Veiculo column
    public Set<Veiculo> getVeiculos() {
        return veiculos;
    }

    //Function whose purpose is to set the Client's Veiculo column
    public void setVeiculos(Set<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    //Function whose purpose is to get the Client's Clienteinstitucional column
    public ClienteInstitucional getClienteinstitucional() {
        return clienteinstitucional;
    }

    //Function whose purpose is to set the Client's Clienteinstitucional column
    public void setClienteinstitucional(ClienteInstitucional clienteinstitucional) {
        this.clienteinstitucional = clienteinstitucional;
    }

}