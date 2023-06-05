package gui;

import dataAccess.DaoEmpleado;
import dataAccess.DaoUsuario;
import logica.Empleado;
import logica.Usuario;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Util.Constantes.*;

public class Register {

    private JLabel titleLabel;
    private JLabel identificationLabel;
    private JTextField identification;
    private JLabel passwordLabel;
    private JPasswordField password;
    private JLabel nombreUsuarioLabel;
    private JTextField nombreUsuario;
    private JLabel telUsuarioLabel;
    private JTextField telUsuario;
    private JLabel dirUsuarioLabel;
    private JTextField dirUsuario;
    private JLabel emailUsuarioLabel;
    private JTextField emailUsuario;

    private JLabel nombreEmpleadoLabel;
    private JTextField nombreEmpleado;
    private JLabel cargoEmpleadoLabel;
    private JTextField cargoEmpleado;

    private JButton registerUserButton;
    private JButton registerEmployeeButton;
    private JButton cancelarButton;



    public void RegisterUI(){
        Object [] tipoRegistroObj ={REGISTRAR_USUARIO, REGISTRAR_EMPLEADO};
        Object tipoRegistro = JOptionPane.showInputDialog(null,SELECCIONA_OPCION, "Elegir", JOptionPane.QUESTION_MESSAGE,null,tipoRegistroObj, tipoRegistroObj[0]);
        if(tipoRegistro.equals(REGISTRAR_USUARIO)){
            userRegisterUI();
        }else{
            employeeRegisterUI();
        }
    }

    public void limpiarCamposUsuario(){
       identification.setText("");
       password.setText("");
       nombreUsuario.setText("");
       telUsuario.setText("");
       dirUsuario.setText("");
       emailUsuario.setText("");

    }
    public void userRegisterUI(){
        // Crear la ventana principal y configurarla
        JFrame ventana = new JFrame("Login Sistema de Biblioteca -> Registro de Usuario");
        ventana.setSize(500, 500);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(null);

        //titulo
        titleLabel = new JLabel("Registar Usuario");
        titleLabel.setBounds(130, 10, 260, 60);
        titleLabel.setFont(new Font("Verdana", Font.BOLD, 24));
        ventana.add(titleLabel);

        //idUsuario
        identificationLabel = new JLabel("Identificación:");
        identificationLabel.setBounds(90, 90, 80, 30);
        ventana.add(identificationLabel);

        identification = new JTextField();
        identification.setBounds(230, 90, 180, 30);
        ventana.add(identification);

        //password
        passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setBounds(90, 140, 80, 30);
        ventana.add(passwordLabel);

        password = new JPasswordField();
        password.setBounds(230, 140, 180, 30);
        ventana.add(password);


        //nombre usuario
        nombreUsuarioLabel = new JLabel("Nombre usuario:");
        nombreUsuarioLabel.setBounds(90, 190, 100, 30);
        ventana.add(nombreUsuarioLabel);

        nombreUsuario = new JTextField();
        nombreUsuario.setBounds(230, 190, 180, 30);
        ventana.add(nombreUsuario);


        //telefono usuario
        telUsuarioLabel = new JLabel("Teléfono:");
        telUsuarioLabel.setBounds(90, 240, 100, 30);
        ventana.add(telUsuarioLabel);

        telUsuario = new JTextField();
        telUsuario.setBounds(230, 240, 180, 30);
        ventana.add(telUsuario);

        //direccion usuario
        dirUsuarioLabel = new JLabel("Dirección:");
        dirUsuarioLabel.setBounds(90, 290, 100, 30);
        ventana.add(dirUsuarioLabel);

        dirUsuario = new JTextField();
        dirUsuario.setBounds(230, 290, 180, 30);
        ventana.add(dirUsuario);

        //direccion usuario
        emailUsuarioLabel = new JLabel("Email:");
        emailUsuarioLabel.setBounds(90, 340, 100, 30);
        ventana.add(emailUsuarioLabel);

        emailUsuario = new JTextField();
        emailUsuario.setBounds(230, 340, 180, 30);
        ventana.add(emailUsuario);

        //boton registrar

        registerUserButton = new JButton("Registrar");
        registerUserButton.setBounds(150, 400, 90, 30);
        ventana.add(registerUserButton);

        //boton cancelar
        cancelarButton = new JButton("Cancelar");
        cancelarButton.setBounds(255, 400, 90, 30);
        ventana.add(cancelarButton);


        registerUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idUser = identification.getText().replace(" ","");
                char[] passwordChars = password.getPassword();
                String pass = new String(passwordChars);
                String nomUsuario = nombreUsuario.getText();
                String telUsr = telUsuario.getText();
                String dirUsr = dirUsuario.getText();
                String emailUsr = emailUsuario.getText();
                if(!idUser.isEmpty() && !pass.isEmpty() && !nomUsuario.isEmpty() && !telUsr.isEmpty() && !dirUsr.isEmpty() && !emailUsr.isEmpty()) {
                    if(!DaoUsuario.existeUsuario(idUser)){
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
                        limpiarCamposUsuario();

                        //0 yes - 1 no
                        int confirm = JOptionPane.showConfirmDialog(null, OTRO_REGISTRO,
                                "¿nuevo registro?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if (confirm == 1) {
                            ventana.dispose();
                            Login login = new Login();
                            login.loginUI();
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, USUARIO_YA_EXISTE);
                        identification.setText("");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, VALIDAR_CAMPOS);
                }
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.dispose();
                Login login = new Login();
                login.loginUI();
            }
        });


        // Mostrar la ventana
        ventana.setVisible(true);
    }

    public void limpiarCamposEmpleado(){
        identification.setText("");
        password.setText("");
        nombreEmpleado.setText("");
        cargoEmpleado.setText("");
    }
    public void employeeRegisterUI(){
        // Crear la ventana principal y configurarla
        JFrame ventana = new JFrame("Sistema de Biblioteca -> Registro de Empleado");
        ventana.setSize(500, 500);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(null);

        //titulo
        titleLabel = new JLabel("Registar Empleado");
        titleLabel.setBounds(130, 10, 260, 60);
        titleLabel.setFont(new Font("Verdana", Font.BOLD, 24));
        ventana.add(titleLabel);

        //idEmpleado
        identificationLabel = new JLabel("Identificación:");
        identificationLabel.setBounds(90, 90, 80, 30);
        ventana.add(identificationLabel);

        identification = new JTextField();
        identification.setBounds(230, 90, 180, 30);
        ventana.add(identification);

        //password
        passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setBounds(90, 140, 80, 30);
        ventana.add(passwordLabel);

        password = new JPasswordField();
        password.setBounds(230, 140, 180, 30);
        ventana.add(password);


        //nombre empleado
        nombreEmpleadoLabel = new JLabel("Nombre empleado:");
        nombreEmpleadoLabel.setBounds(90, 190, 110, 30);
        ventana.add(nombreEmpleadoLabel);

        nombreEmpleado = new JTextField();
        nombreEmpleado.setBounds(230, 190, 180, 30);
        ventana.add(nombreEmpleado);


        //telefono empleado
        cargoEmpleadoLabel = new JLabel("Cargo:");
        cargoEmpleadoLabel.setBounds(90, 240, 100, 30);
        ventana.add(cargoEmpleadoLabel);

        cargoEmpleado = new JTextField();
        cargoEmpleado.setBounds(230, 240, 180, 30);
        ventana.add(cargoEmpleado);


        //boton registrar

        registerEmployeeButton = new JButton("Registrar");
        registerEmployeeButton.setBounds(150, 400, 90, 30);
        ventana.add(registerEmployeeButton);

        //boton cancelar
        cancelarButton = new JButton("Cancelar");
        cancelarButton.setBounds(255, 400, 90, 30);
        ventana.add(cancelarButton);

        registerEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idEmployee = identification.getText().replace(" ","");
                char[] passwordChars = password.getPassword();
                String pass = new String(passwordChars);
                String nomEmpleado = nombreEmpleado.getText();
                String cargoEmployee = cargoEmpleado.getText();

                if(!idEmployee.isEmpty() && !pass.isEmpty() && !nomEmpleado.isEmpty() && !cargoEmployee.isEmpty()) {
                    if(!DaoEmpleado.existeEmpleado(idEmployee)) {
                        Empleado registroEmpleado = new Empleado();
                        registroEmpleado.setIdEmpleado(idEmployee);
                        registroEmpleado.setPasswordEmpleado(pass);
                        registroEmpleado.setNombreEmpleado(nomEmpleado);
                        registroEmpleado.setCargoEmpleado(cargoEmployee);
                        DaoEmpleado.guardarEmpleado(registroEmpleado);
                        if (DaoEmpleado.existeEmpleado(idEmployee)) {
                            JOptionPane.showMessageDialog(null, REGISTRO_EMPLEADO_EXISTOSO);
                        }

                        limpiarCamposEmpleado();
                        //0 yes - 1 no
                        int confirm = JOptionPane.showConfirmDialog(null, OTRO_REGISTRO,
                                "¿nuevo registro?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if (confirm == 1) {
                            ventana.dispose();
                            Login login = new Login();
                            login.loginUI();
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, EMPLEADO_YA_EXISTE);
                        identification.setText("");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, VALIDAR_CAMPOS);
                }
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.dispose();
                Login login = new Login();
                login.loginUI();
            }
        });

        // Mostrar la ventana
        ventana.setVisible(true);
    }
}
