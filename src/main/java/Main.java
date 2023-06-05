import dataAccess.ConexionBD;
import dataAccess.DaoUsuario;
import gui.Login;
import gui.Register;

import java.sql.Connection;

public class Main {
    public static void main (String [ ] args) {
        Login login = new Login();
        login.loginUI();
        //System.out.println(DaoUsuario.existeUsuario("USU0001"));
        /*Register register = new Register();
        register.RegisterUI();*/
    }
}
