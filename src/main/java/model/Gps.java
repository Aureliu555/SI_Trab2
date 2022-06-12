package model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "gps")
public class Gps {
    //Stores ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    //Stores Marcatemporal
    @Column(name = "marcatemporal", nullable = false)
    private Timestamp marcatemporal;

    //Stores Longitude
    @Column(name = "longitude")
    private Double longitude;

    //Stores Latitude
    @Column(name = "latitude")
    private Double latitude;

    //Stores Estado
    @Column(name = "estado", nullable = false, length = 20)
    private String estado;

    //Stores Matricula
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "matricula")
    private Veiculo matricula;

    //Stores Vrs
    @Version
    @Column(name = "vrs")
    private Integer vrs;

    //Establishes relationship between Gps and Veiculo
    @OneToMany(mappedBy = "gps")
    private Set<Veiculo> veiculos = new LinkedHashSet<>();

    //Establishes relationship between Gps and Processados
    @OneToMany(mappedBy = "gps")
    private Set<Processado> processados = new LinkedHashSet<>();

    //Function whose purpose is to get the Gps's Id column
    public Integer getId() {
        return id;
    }

    //Function whose purpose is to set the Gps's Id column
    public void setId(Integer id) {
        this.id = id;
    }

    //Function whose purpose is to get the Gps's Marcatemporal column
    public Timestamp getMarcatemporal() {
        return marcatemporal;
    }

    //Function whose purpose is to set the Gps's Marcatemporal column
    public void setMarcatemporal(Timestamp marcatemporal) {
        this.marcatemporal = marcatemporal;
    }

    //Function whose purpose is to get the Gps's Longitude column
    public Double getLongitude() {
        return longitude;
    }

    //Function whose purpose is to set the Gps's Longitude column
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    //Function whose purpose is to get the Gps's Latitude column
    public Double getLatitude() {
        return latitude;
    }

    //Function whose purpose is to set the Gps's Latitude column
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    //Function whose purpose is to get the Gps's Estado column
    public String getEstado() {
        return estado;
    }

    //Function whose purpose is to set the Gps's Estado column
    public void setEstado(String estado) {
        this.estado = estado;
    }

    //Function whose purpose is to get the Gps's Matricula column
    public Veiculo getMatricula() {
        return matricula;
    }

    //Function whose purpose is to set the Gps's Matricula column
    public void setMatricula(Veiculo matricula) {
        this.matricula = matricula;
    }

    //Function whose purpose is to get the Gps's Vrs column
    public Integer getVrs() {
        return vrs;
    }

    //Function whose purpose is to get the Gps's Vrs column
    public void setVrs(Integer vrs) {
        this.vrs = vrs;
    }

    //Function whose purpose is to get the Gps's Veiculo column
    public Set<Veiculo> getVeiculos() {
        return veiculos;
    }

    //Function whose purpose is to set the Gps's Veiculo column
    public void setVeiculos(Set<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    //Function whose purpose is to get the Gps's Processado column
    public Set<Processado> getProcessados() {
        return processados;
    }

    //Function whose purpose is to set the Gps's Processado column
    public void setProcessados(Set<Processado> processados) {
        this.processados = processados;
    }

}