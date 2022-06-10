package model;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "alarme")
public class Alarme {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false)
    private Processado processado;

    @Column(name = "datahora", nullable = false)
    private Instant datahora;

    @Version
    @Column(name = "vrs")
    private Integer vrs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Processado getProcessado() {
        return processado;
    }

    public void setProcessado(Processado processado) {
        this.processado = processado;
    }

    public Instant getDatahora() {
        return datahora;
    }

    public void setDatahora(Instant datahora) {
        this.datahora = datahora;
    }

    public Integer getVrs() {
        return vrs;
    }

    public void setVrs(Integer vrs) {
        this.vrs = vrs;
    }

}