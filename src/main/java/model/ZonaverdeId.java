package model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ZonaverdeId implements Serializable {
    private static final long serialVersionUID = 6326281389366575816L;
    //Stores Latitude
    @Column(name = "latitude", nullable = false)
    private Double latitude;

    //Stores Longitude
    @Column(name = "longitude", nullable = false)
    private Double longitude;

    //Function whose purpose is to get the GreenZoneId's Latitude column
    public Double getLatitude() {
        return latitude;
    }

    //Function whose purpose is to set the GreenZoneId's Latitude column
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    //Function whose purpose is to get the GreenZoneId's Longitude column
    public Double getLongitude() {
        return longitude;
    }

    //Function whose purpose is to set the GreenZoneId's Longitude column
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    //Checks if object is equal
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZonaverdeId entity = (ZonaverdeId) o;
        return Objects.equals(this.latitude, entity.latitude) &&
                Objects.equals(this.longitude, entity.longitude);
    }

    //Returns the object's hashcode
    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude);
    }

}