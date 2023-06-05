package gui;

import dataAccess.DaoUsuario;
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

    private JButton registerUserButton;

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
        registerUserButton.setBounds(205, 400, 90, 30);
        ventana.add(registerUserButton);

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


                Usuario registroUsuario = new Usuario();
                registroUsuario.setIdUsuario(idUser);
                registroUsuario.setPasswordUsuario(pass);
                registroUsuario.setNombreUsuario(nomUsuario);
                registroUsuario.setTelUsuario(telUsr);
                registroUsuario.setDirUsuario(dirUsr);
                registroUsuario.setEmailUsuario(emailUsr);
                DaoUsuario.guardarUsuario(registroUsuario);
                System.out.println("Usuario Registrado con exito");
                limpiarCamposUsuario();
            }
        });



        // Mostrar la ventana
        ventana.setVisible(true);
    }

    public void employeeRegisterUI(){
        JOptionPane.showMessageDialog(null, "en desarrollo...");
    }
}
