package aula_practica;

import jakarta.persistence.*;

@Entity
@Table(name = "irmaos")
public class Irmao {
    @EmbeddedId
    private IrmaoId id;

    @MapsId("irmao1")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "irmao1")
    private Pessoa irmao1;

    @MapsId("irmao2")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "irmao2")
    private Pessoa irmao2;

    public IrmaoId getId() {
        return id;
    }

    public void setId(IrmaoId id) {
        this.id = id;
    }

    public Pessoa getIrmao1() {
        return irmao1;
    }

    public void setIrmao1(Pessoa irmao1) {
        this.irmao1 = irmao1;
    }

    public Pessoa getIrmao2() {
        return irmao2;
    }

    public void setIrmao2(Pessoa irmao2) {
        this.irmao2 = irmao2;
    }

}