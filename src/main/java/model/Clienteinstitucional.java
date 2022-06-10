package model;

import jakarta.persistence.*;

@Entity
@Table(name = "clienteinstitucional")
public class Clienteinstitucional {
    @Id
    @Column(name = "nif", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "nif", nullable = false)
    private Cliente cliente;

    @Column(name = "nomecontato", nullable = false, length = 150)
    private String nomecontato;


    @Version
    @Column(name = "vrs")
    private Integer vrs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNomecontato() {
        return nomecontato;
    }

    public void setNomecontato(String nomecontato) {
        this.nomecontato = nomecontato;
    }

    public Integer getVrs() {
        return vrs;
    }

    public void setVrs(Integer vrs) {
        this.vrs = vrs;
    }

}