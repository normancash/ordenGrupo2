package ni.edu.uam.orden.model;

import lombok.Getter;
import lombok.Setter;
import ni.edu.uam.orden.calculators.CalculatorPrecioPorUnidad;
import org.openxava.annotations.*;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Embeddable
@Getter
@Setter
public class Detalle {

    private int cantidad;

    @ManyToOne(fetch = FetchType.LAZY)
    private Producto producto;

    @DefaultValueCalculator(
            value= CalculatorPrecioPorUnidad.class,
            properties = @PropertyValue(
                    name="numeroProducto",
                    from = "producto.id"
            )

    )
    @Money
    @ReadOnly
    private BigDecimal precioPorUnidad;

    @Money
    @Depends("precioPorUnidad,cantidad")
    public BigDecimal getSubtotal() {
        if (precioPorUnidad == null) {
            return BigDecimal.ZERO;
        }
        return precioPorUnidad.multiply(new BigDecimal(cantidad));
    }

}
