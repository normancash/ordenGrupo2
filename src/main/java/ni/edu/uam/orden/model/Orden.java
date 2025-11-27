package ni.edu.uam.orden.model;

import lombok.Getter;
import lombok.Setter;
import ni.edu.uam.orden.calculators.CalculatorNumeroOrden;
import org.openxava.annotations.DefaultValueCalculator;
import org.openxava.annotations.ListProperties;
import org.openxava.annotations.PropertyValue;
import org.openxava.annotations.ReadOnly;
import org.openxava.calculators.CurrentLocalDateCalculator;
import org.openxava.calculators.CurrentYearCalculator;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Getter
@Setter
public class Orden extends BaseEntity{
    @DefaultValueCalculator(
            CurrentYearCalculator.class)
    @ReadOnly
    private int anioFiscal;
    @DefaultValueCalculator(
            value= CalculatorNumeroOrden.class,
            properties = @PropertyValue(name="anioFiscal")
            )
    @ReadOnly
    private int numeroOrden;
    @DefaultValueCalculator(
            CurrentLocalDateCalculator.class)
    @ReadOnly
    private LocalDate fecha;
    private String descripcion;

    @ElementCollection
    @ListProperties(
            "producto.nombre" +
            ",precioPorUnidad" +
            ",cantidad" +
            ",subtotal"
    )
    Collection<Detalle> detalles;
}
