package model;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "clienteparticular", indexes = {
        @Index(name = "clienteparticular_cc_key", columnList = "cc", unique = true)
})
public class ClienteParticular {
    //Stores NIF
    @Id
    @Column(name = "nif", nullable = false)
    private Integer id;

    //Stores NIF
    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "nif", nullable = false)
    private Cliente cliente;

    //Stores Cc
    @Column(name = "cc", nullable = false)
    private Integer cc;

    //Stores Vrs
    @Version
    @Column(name = "vrs")
    private Integer vrs;

    //Establishes relationship between ClienteParticular and Cliente
    @OneToMany(mappedBy = "cpnif")
    private Set<Cliente> clientes = new LinkedHashSet<>();

    //Function whose purpose is to get the ParticularClient's Id column
    public Integer getId() {
        return id;
    }

    //Function whose purpose is to set the ParticularClient's Id column
    public void setId(Integer id) {
        this.id = id;
    }

    //Function whose purpose is to get the ParticularClient's Cliente column
    public Cliente getCliente() {
        return cliente;
    }

    //Function whose purpose is to set the ParticularClient's Cliente column
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    //Function whose purpose is to get the ParticularClient's Cc column
    public Integer getCc() {
        return cc;
    }

    //Function whose purpose is to set the ParticularClient's Cc column
    public void setCc(Integer cc) {
        this.cc = cc;
    }

    //Function whose purpose is to get the ParticularClient's Vrs column
    public Integer getVrs() {
        return vrs;
    }

    //Function whose purpose is to set the ParticularClient's Vrs column
    public void setVrs(Integer vrs) {
        this.vrs = vrs;
    }

    //Function whose purpose is to get the ParticularClient's Cliente column
    public Set<Cliente> getClientes() {
        return clientes;
    }

    //Function whose purpose is to set the ParticularClient's Cliente column
    public void setClientes(Set<Cliente> clientes) {
        this.clientes = clientes;
    }

}