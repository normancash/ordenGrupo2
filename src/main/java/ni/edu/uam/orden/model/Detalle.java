package ni.edu.uam.orden.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Embeddable
@Getter
@Setter
public class Detalle {

    private int cantidad;

    @ManyToOne(fetch = FetchType.LAZY)
    private Producto producto;

}
