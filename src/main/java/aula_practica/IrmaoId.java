package aula_practica;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Embeddable
public class IrmaoId implements Serializable {
    private static final long serialVersionUID = -1952333941800947936L;
    @Column(name = "irmao1", nullable = false, precision = 8)
    private BigDecimal irmao1;

    @Column(name = "irmao2", nullable = false, precision = 8)
    private BigDecimal irmao2;

    public BigDecimal getIrmao1() {
        return irmao1;
    }

    public void setIrmao1(BigDecimal irmao1) {
        this.irmao1 = irmao1;
    }

    public BigDecimal getIrmao2() {
        return irmao2;
    }

    public void setIrmao2(BigDecimal irmao2) {
        this.irmao2 = irmao2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IrmaoId entity = (IrmaoId) o;
        return Objects.equals(this.irmao2, entity.irmao2) &&
                Objects.equals(this.irmao1, entity.irmao1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(irmao2, irmao1);
    }

}