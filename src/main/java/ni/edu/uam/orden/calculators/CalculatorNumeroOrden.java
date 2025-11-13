package ni.edu.uam.orden.calculators;

import lombok.Getter;
import lombok.Setter;
import org.openxava.calculators.ICalculator;
import org.openxava.jpa.XPersistence;

import javax.persistence.Query;

public class CalculatorNumeroOrden implements ICalculator {

    @Getter
    @Setter
    int anioFiscal;

    @Override
    public Object calculate() throws Exception {
        Integer numero = 1;
        Query query = XPersistence.getManager()
            .createQuery("SELECT max(f.numeroOrden)" +
                " FROM Orden f " +
                " WHERE f.anioFiscal = :anioFiscal");
        query.setParameter("anioFiscal", anioFiscal);
        numero = (Integer)query.getSingleResult();
        return (numero==null)?1:numero + 1;
    }
}
