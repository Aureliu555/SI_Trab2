package model;

import jakarta.persistence.*;

@Entity
@Table(name = "alarmes")
public class Alarme {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_registo")
    private RegistosProcessado idRegisto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "veiculo")
    private Veiculo veiculo;


    public RegistosProcessado getIdRegisto() {
        return idRegisto;
    }

    public void setIdRegisto(RegistosProcessado idRegisto) {
        this.idRegisto = idRegisto;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

}