package ni.edu.uam.orden.model;

import lombok.Getter;
import lombok.Setter;
import ni.edu.uam.orden.util.Encriptar;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Entity;

@Entity
public class Usuario extends BaseEntity {

    public String usuario;
    public String password;


    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = Encriptar.code(password);
    }
}
