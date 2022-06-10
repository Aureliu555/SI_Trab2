package model;

import jakarta.persistence.*;

@Entity
@Table(name = "invalido")
public class Invalido {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false)
    private RegistoNProcessado registonprocessado;

    @Version
    @Column(name = "vrs")
    private Integer vrs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RegistoNProcessado getRegistonprocessado() {
        return registonprocessado;
    }

    public void setRegistonprocessado(RegistoNProcessado registonprocessado) {
        this.registonprocessado = registonprocessado;
    }

    public Integer getVrs() {
        return vrs;
    }

    public void setVrs(Integer vrs) {
        this.vrs = vrs;
    }

}