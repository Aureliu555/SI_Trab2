package model;

import jakarta.persistence.*;
import org.eclipse.persistence.annotations.OptimisticLocking;
import org.eclipse.persistence.annotations.OptimisticLockingType;

@Entity
@Table(name = "invalido")
@OptimisticLocking(type = OptimisticLockingType.VERSION_COLUMN)
public class Invalido {
    //Stores ID
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    //Stores ID
    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false)
    private RegistoNProcessado registonprocessado;

    //Stores Vrs
    @Version
    @Column(name = "vrs")
    private Integer vrs;

    //Function whose purpose is to get the Invalid's ID column
    public Integer getId() {
        return id;
    }

    //Function whose purpose is to set the Invalid's ID column
    public void setId(Integer id) {
        this.id = id;
    }

    //Function whose purpose is to get the Invalid's Registonprocessado column
    public RegistoNProcessado getRegistonprocessado() {
        return registonprocessado;
    }

    //Function whose purpose is to set the Invalid's Registonprocessado column
    public void setRegistonprocessado(RegistoNProcessado registonprocessado) {
        this.registonprocessado = registonprocessado;
    }

    //Function whose purpose is to get the Invalid's Vrs column
    public Integer getVrs() {
        return vrs;
    }

    //Function whose purpose is to set the Invalid's Vrs column
    public void setVrs(Integer vrs) {
        this.vrs = vrs;
    }

}