package model;

import jakarta.persistence.*;

@Entity
@Table(name = "clienteinstitucional")
public class ClienteInstitucional {
    //Stores Nif
    @Id
    @Column(name = "nif", nullable = false)
    private Integer id;

    //Stores Nif
    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "nif", nullable = false)
    private Cliente cliente;

    //Stores Nomecontato
    @Column(name = "nomecontato", nullable = false, length = 150)
    private String nomecontato;

    //Stores Vrs
    @Version
    @Column(name = "vrs")
    private Integer vrs;

    //Function whose purpose is to get the InstitutionalClient's ID column
    public Integer getId() {
        return id;
    }

    //Function whose purpose is to set the InstitutionalClient's ID column
    public void setId(Integer id) {
        this.id = id;
    }

    //Function whose purpose is to get the InstitutionalClient's Cliente column
    public Cliente getCliente() {
        return cliente;
    }

    //Function whose purpose is to set the InstitutionalClient's Cliente column
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    //Function whose purpose is to get the InstitutionalClient's Nomecontato column
    public String getNomecontato() {
        return nomecontato;
    }

    //Function whose purpose is to set the InstitutionalClient's Nomecontato column
    public void setNomecontato(String nomecontato) {
        this.nomecontato = nomecontato;
    }

    //Function whose purpose is to get the InstitutionalClient's Vrs column
    public Integer getVrs() {
        return vrs;
    }

    //Function whose purpose is to set the InstitutionalClient's Vrs column
    public void setVrs(Integer vrs) {
        this.vrs = vrs;
    }

}