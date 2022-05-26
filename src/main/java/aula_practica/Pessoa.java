package aula_practica;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "pessoas")
public class Pessoa {
    @Id
    @Column(name = "cc", precision = 8)
    private int id;

    @Column(name = "nome", length = 80)
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ccpai")
    private Pessoa ccpai;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ccmae")
    private Pessoa ccmae;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pessoa getCcpai() {
        return ccpai;
    }

    public void setCcpai(Pessoa ccpai) {
        this.ccpai = ccpai;
    }

    public Pessoa getCcmae() {
        return ccmae;
    }

    public void setCcmae(Pessoa ccmae) {
        this.ccmae = ccmae;
    }

}