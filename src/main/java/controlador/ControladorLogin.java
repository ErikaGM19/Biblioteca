package controlador;

import dataAccess.DaoEmpleado;
import dataAccess.DaoUsuario;
import gui.EmployeeUI.EmployeeUI;
import gui.UserUI.UserUI;
import logica.Empleado;
import logica.Usuario;

import javax.swing.*;

import static Util.Constantes.*;

public class ControladorLogin {
    //valida si el password ingresado por usuario es igual que el password guardado en base de datos
    public static boolean validarPasswordUsuario(String idUser, String pass){
        boolean result = false;
        DaoUsuario daoUsuario = new DaoUsuario();
        Usuario usuario = daoUsuario.obtenerUsuarioPorID(idUser);
        String password = usuario.getPasswordUsuario();
        if (pass.equals(password)){
            result = true;
        }
        return result;
    }
    //valida si el password ingresado por empleado es igual que el password guardado en base de datos

    public static boolean validarPasswordEmpleado(String idEmpleado, String pass){
        boolean result = false;
        DaoEmpleado daoEmpleado = new DaoEmpleado();
        Empleado empleado = daoEmpleado.obtenerEmpleadoPorID(idEmpleado);
        String password = empleado.getPasswordEmpleado();
        if (pass.equals(password)){
            result = true;
        }
        return result;
    }
    //valida si los campos no estan vacios y si es usuario o empleado y lo enruta a su respectiva interfaz
    public static void loginController(String idUser, String pass, boolean isUserSelected, JFrame ventana) {
        if(!idUser.isEmpty() && !pass.isEmpty()){
            if(isUserSelected){
                if(validarPasswordUsuario(idUser, pass)) {
                    ventana.dispose();
                    String nombreUsuario = DaoUsuario.obtenerNombreUsuarioPorID(idUser);
                    JOptionPane.showMessageDialog(null, BIENVENIDO+nombreUsuario);
                    UserUI userUI = new UserUI();
                    userUI.ventanaUser(idUser);
                }else{
                    JOptionPane.showMessageDialog(null, VERIFICAR_DATOS);
                }
            }else{
                if(validarPasswordEmpleado(idUser, pass)) {
                    ventana.dispose();
                    String nombreEmpleado = DaoEmpleado.obtenerNombreEmpleadoPorID(idUser);
                    JOptionPane.showMessageDialog(null, BIENVENIDO+nombreEmpleado);
                    EmployeeUI employeeUI = new EmployeeUI();
                    employeeUI.ventanaEmployee(idUser);
                }else{
                    JOptionPane.showMessageDialog(null, VERIFICAR_DATOS);
                }
            }

        }else{
            JOptionPane.showMessageDialog(null, VALIDAR_CAMPOS);
        }
    }

}
