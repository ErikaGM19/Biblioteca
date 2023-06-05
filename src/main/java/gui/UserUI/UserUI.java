package gui.UserUI;

import javax.swing.*;
import java.awt.*;

public class UserUI {

    private JLabel userIDLabel;

    public void ventanaUser(String idUser) {
        // Crear la ventana principal y configurarla
        JFrame ventana = new JFrame("Sistema de Biblioteca -> Usuario "+idUser);
        ventana.setSize(800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(null);
        //userName
        userIDLabel = new JLabel("Usuario: "+idUser);
        userIDLabel.setBounds(20, 10, 200, 30);
        userIDLabel.setFont(new Font("Verdana", Font.BOLD, 14));
        ventana.add(userIDLabel);

        // Mostrar la ventana
        ventana.setVisible(true);
    }
}
