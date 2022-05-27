package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente_institucional")
public class ClienteInstitucional {
    @Id
    @Column(name = "nif_cliente", nullable = false, length = 15)
    private String id;

    @Column(name = "nome_contacto", nullable = false, length = 100)
    private String nomeContacto;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomeContacto() {
        return nomeContacto;
    }

    public void setNomeContacto(String nomeContacto) {
        this.nomeContacto = nomeContacto;
    }

}