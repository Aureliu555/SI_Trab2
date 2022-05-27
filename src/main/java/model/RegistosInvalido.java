package model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "registos_invalidos")
public class RegistosInvalido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registo_i", nullable = false)
    private Integer id;

    @Column(name = "registo_data", nullable = false)
    private LocalDate registoData;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getRegistoData() {
        return registoData;
    }

    public void setRegistoData(LocalDate registoData) {
        this.registoData = registoData;
    }

}