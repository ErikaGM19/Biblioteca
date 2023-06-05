package gui.EmployeeUI;

import javax.swing.*;
import java.awt.*;

public class EmployeeUI {
    private JLabel employeeIDLabel;

    public void ventanaEmployee(String idEmployee) {
        // Crear la ventana principal y configurarla
        JFrame ventana = new JFrame("Sistema de Biblioteca -> Empleado "+idEmployee);
        ventana.setSize(500, 500);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(null);
        //userName
        employeeIDLabel = new JLabel("Empleado: "+idEmployee);
        employeeIDLabel.setBounds(20, 10, 200, 30);
        employeeIDLabel.setFont(new Font("Verdana", Font.BOLD, 14));
        ventana.add(employeeIDLabel);


        // Mostrar la ventana
        ventana.setVisible(true);
    }
}
