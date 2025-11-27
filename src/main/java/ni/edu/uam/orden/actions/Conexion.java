package ni.edu.uam.orden.actions;

import com.openxava.naviox.actions.ForwardToOriginalURIBaseAction;
import com.openxava.naviox.impl.SignInHelper;
import org.openxava.jpa.XPersistence;
import org.openxava.util.Is;

import javax.persistence.Query;

public class Conexion extends ForwardToOriginalURIBaseAction {

    public void execute() throws Exception {
        SignInHelper.initRequest(getRequest(), getView());
        if (getErrors().contains()) return;
        String userName = getView().getValueString("user");
        String password = getView().getValueString("password");
        if (Is.emptyString(userName, password)) {
            addError("unauthorized_user");
            return;
        }
        Long count = 0L;
        Query query = XPersistence.getManager().createQuery("SELECT COUNT(*)" +
                " FROM Usuario e WHERE e.usuario = :username AND e.password = :password ");
        query.setParameter("username", userName);
        query.setParameter("password", password);
        count =  (Long) query.getSingleResult();
        if (count == 0) {
            addError("unauthorized_user");
            return;
        }
        SignInHelper.signIn(getRequest(), userName);
        getView().reset();
        getContext().resetAllModulesExceptCurrent(getRequest());
        forwardToOriginalURI();
    }

}
