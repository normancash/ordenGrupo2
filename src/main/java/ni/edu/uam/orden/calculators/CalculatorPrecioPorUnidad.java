package ni.edu.uam.orden.calculators;

import lombok.Getter;
import lombok.Setter;
import ni.edu.uam.orden.model.Producto;
import org.openxava.calculators.ICalculator;
import org.openxava.jpa.XPersistence;

import java.util.UUID;

public class CalculatorPrecioPorUnidad
        implements ICalculator {

    @Getter
    @Setter
    String numeroProducto;


    @Override
    public Object calculate() throws Exception {
        Producto producto = XPersistence.getManager()
                .find(Producto.class, numeroProducto);
        return producto.getPrecio();
    }
}
