package controlador;

import dataAccess.DaoEmpleado;
import dataAccess.DaoUsuario;
import gui.Login;
import logica.Empleado;
import logica.Usuario;

import javax.swing.*;

import static Util.Constantes.*;

public class ControladorRegister {
    public static void UserRegisterController(String idUser, String pass, String nomUsuario, String telUsr, String dirUsr, String emailUsr) {
        Usuario registroUsuario = new Usuario();
        registroUsuario.setIdUsuario(idUser);
        registroUsuario.setPasswordUsuario(pass);
        registroUsuario.setNombreUsuario(nomUsuario);
        registroUsuario.setTelUsuario(telUsr);
        registroUsuario.setDirUsuario(dirUsr);
        registroUsuario.setEmailUsuario(emailUsr);
        DaoUsuario.guardarUsuario(registroUsuario);
        if (DaoUsuario.existeUsuario(idUser)) {
            JOptionPane.showMessageDialog(null, REGISTRO_USUARIO_EXISTOSO);
        }
    }
    public static void EmployeeRegisterController(String idEmployee, String pass, String nomEmpleado, String cargoEmployee) {
        Empleado registroEmpleado = new Empleado();
        registroEmpleado.setIdEmpleado(idEmployee);
        registroEmpleado.setPasswordEmpleado(pass);
        registroEmpleado.setNombreEmpleado(nomEmpleado);
        registroEmpleado.setCargoEmpleado(cargoEmployee);
        DaoEmpleado.guardarEmpleado(registroEmpleado);
        if (DaoEmpleado.existeEmpleado(idEmployee)) {
            JOptionPane.showMessageDialog(null, REGISTRO_EMPLEADO_EXISTOSO);
        }
    }
}
