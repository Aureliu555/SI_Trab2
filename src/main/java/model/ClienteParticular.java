package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente_particular")
public class ClienteParticular {
    @Id
    @Column(name = "cliente_nif", nullable = false, length = 15)
    private String id;

    @Column(name = "cc", nullable = false, length = 15)
    private String cc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

}