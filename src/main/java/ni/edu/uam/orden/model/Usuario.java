package ni.edu.uam.orden.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Usuario extends BaseEntity {

    public String usuario;
    public String password;

}
