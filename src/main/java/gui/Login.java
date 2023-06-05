package gui;
import dataAccess.DaoEmpleado;
import dataAccess.DaoUsuario;
import gui.EmployeeUI.EmployeeUI;
import gui.UserUI.UserUI;
import logica.Empleado;
import logica.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static Util.Constantes.*;

public class Login extends JFrame {
    private JLabel titleLabel;
    private JLabel identificationLabel;
    private JTextField identification;
    private JLabel passwordLabel;
    private JPasswordField password;
    private JLabel selecRadioText;
    private JLabel userRadioButtonLabel;
    private JRadioButton userRadioButton;
    private JLabel employeeRadioButtonLabel;
    private JRadioButton employeeRadioButton;
    private JButton loginButton;
    private JLabel createUserLabel;

    public boolean validarPasswordUsuario(String idUser, String pass){
        boolean result = false;
        DaoUsuario daoUsuario = new DaoUsuario();
        Usuario usuario = daoUsuario.obtenerUsuarioPorID(idUser);
        String password = usuario.getPasswordUsuario();
        if (pass.equals(password)){
            result = true;
        }
        return result;
    }
    public boolean validarPasswordEmpleado(String idEmpleado, String pass){
        boolean result = false;
        DaoEmpleado daoEmpleado = new DaoEmpleado();
        Empleado empleado = daoEmpleado.obtenerEmpleadoPorID(idEmpleado);
        String password = empleado.getPasswordEmpleado();
        if (pass.equals(password)){
            result = true;
        }
        return result;
    }


    public void loginUI() {
        // Crear la ventana principal y configurarla
        JFrame ventana = new JFrame("Login Sistema de Biblioteca");
        ventana.setSize(500, 500);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(null);

        //titulo
        titleLabel = new JLabel("Biblioteca");
        titleLabel.setBounds(170, 10, 160, 60);
        titleLabel.setFont(new Font("Verdana", Font.BOLD, 24));
        ventana.add(titleLabel);

        //idUsuario
        identificationLabel = new JLabel("Identificación:");
        identificationLabel.setBounds(90, 110, 80, 30);
        ventana.add(identificationLabel);

        identification = new JTextField();
        identification.setBounds(230, 110, 180, 30);
        ventana.add(identification);

        //password
        passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setBounds(90, 160, 80, 30);
        ventana.add(passwordLabel);

        password = new JPasswordField();
        password.setBounds(230, 160, 180, 30);
        ventana.add(password);

        //radiobutons

        selecRadioText = new JLabel("Selecciona la opcion a la que perteneces: ");
        selecRadioText.setBounds(90, 210, 250, 30);
        ventana.add(selecRadioText);

        userRadioButtonLabel = new JLabel("Usuario");
        userRadioButtonLabel.setBounds(110, 230, 60, 30);
        ventana.add(userRadioButtonLabel);
        userRadioButton = new JRadioButton();
        userRadioButton.setBounds(90, 230, 20, 30);
        ventana.add(userRadioButton);

        employeeRadioButtonLabel = new JLabel("Empleado");
        employeeRadioButtonLabel.setBounds(210, 230, 60, 30);
        ventana.add(employeeRadioButtonLabel);
        employeeRadioButton = new JRadioButton();
        employeeRadioButton.setBounds(190, 230, 20, 30);
        ventana.add(employeeRadioButton);

        // Agrupar los radio buttons para que solo se pueda seleccionar uno a la vez
        ButtonGroup radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(userRadioButton);
        radioButtonGroup.add(employeeRadioButton);

        // boton login
        loginButton = new JButton("Entrar");
        loginButton.setBounds(205, 310, 70, 30);
        ventana.add(loginButton);

        //registrarse
        createUserLabel = new JLabel("Registrarse");
        createUserLabel.setBounds(206, 360, 70, 30);
        createUserLabel.setForeground(Color.BLUE);
        ventana.add(createUserLabel);

        //Acción al hacer clic en el Jbutton "Entrar"
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idUser = identification.getText().replace(" ","");
                char[] passwordChars = password.getPassword();
                String pass = new String(passwordChars);

                boolean isUserSelected = userRadioButton.isSelected();
                boolean isEmployeeSelected = employeeRadioButton.isSelected();
                //aqui se cerrara la ventana
                // y se le pasaran los parametros a algun metodo en controladorLogin para que valide por cual
                // ruta de interfaz irse dependiendo de cual esta en true si isUserSelected o isEmployeeSelected

                if(!idUser.isEmpty() && !pass.isEmpty()){
                    if(isUserSelected){
                        if(validarPasswordUsuario(idUser, pass )) {
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
        });


        // Acción al hacer clic en el JLabel "Registrarse"
        createUserLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ventana.dispose(); // Cierra la ventana actual
                Register register = new Register();
                register.RegisterUI();
            }
        });

        // Mostrar la ventana
        ventana.setVisible(true);
    }

}
