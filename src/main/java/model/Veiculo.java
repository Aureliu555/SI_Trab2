package model;

import jakarta.persistence.*;

@Entity
@Table(name = "veiculo")
public class Veiculo {
    @Id
    @Column(name = "matricula", nullable = false, length = 30)
    private String id;

    @Column(name = "nome_condutor", nullable = false, length = 100)
    private String nomeCondutor;

    @Column(name = "telefone_condutor", nullable = false, length = 20)
    private String telefoneCondutor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_gps")
    private EquipamentoGp idGps;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_nif")
    private Cliente clienteNif;

    @Column(name = "alarmes")
    private Integer alarmes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomeCondutor() {
        return nomeCondutor;
    }

    public void setNomeCondutor(String nomeCondutor) {
        this.nomeCondutor = nomeCondutor;
    }

    public String getTelefoneCondutor() {
        return telefoneCondutor;
    }

    public void setTelefoneCondutor(String telefoneCondutor) {
        this.telefoneCondutor = telefoneCondutor;
    }

    public EquipamentoGp getIdGps() {
        return idGps;
    }

    public void setIdGps(EquipamentoGp idGps) {
        this.idGps = idGps;
    }

    public Cliente getClienteNif() {
        return clienteNif;
    }

    public void setClienteNif(Cliente clienteNif) {
        this.clienteNif = clienteNif;
    }

    public Integer getAlarmes() {
        return alarmes;
    }

    public void setAlarmes(Integer alarmes) {
        this.alarmes = alarmes;
    }

}