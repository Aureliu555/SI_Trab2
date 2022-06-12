package model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name = "alarme")
public class Alarme {
    //Stores ID
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    //Stores ID
    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false)
    private Processado processado;

    //Stores Datahora
    @Column(name = "datahora", nullable = false)
    private Timestamp datahora;

    //Stores Vrs
    @Version
    @Column(name = "vrs")
    private Integer vrs;

    //Function whose purpose is to get the Alarm's ID column
    public Integer getId() {
        return id;
    }

    //Function whose purpose is to set the Alarm's ID column
    public void setId(Integer id) {
        this.id = id;
    }

    //Function whose purpose is to get the Alarm's Processado column
    public Processado getProcessado() {
        return processado;
    }

    ////Function whose purpose is to set the Alarm's Processado column
    public void setProcessado(Processado processado) {
        this.processado = processado;
    }

    //Function whose purpose is to get the Alarm's Datahora column
    public Timestamp getDatahora() {
        return datahora;
    }

    //Function whose purpose is to set the Alarm's Datahora column
    public void setDatahora(Timestamp datahora) {
        this.datahora = datahora;
    }

    //Function whose purpose is to get the Alarm's Vrs column
    public Integer getVrs() {
        return vrs;
    }

    //Fucntion whose purpose is to set the Alarm's Vrs column
    public void setVrs(Integer vrs) {
        this.vrs = vrs;
    }

}