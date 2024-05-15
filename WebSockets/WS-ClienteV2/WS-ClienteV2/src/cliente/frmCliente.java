/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import server.CalculadoraWSP;
import server.CalculadoraWSPService;

/**
 *
 * @author Santiago
 */
public class frmCliente extends JFrame {

    private JTextField displayField;
    private String currentOperation;
    private double currentResult;
    private  CalculadoraWSP calculadoraCliente;
    
    public frmCliente() {
        
        
        calculadoraCliente = new CalculadoraWSPService().getCalculadoraWSPPort();

        // Configurar la ventana principal
        setTitle( "Calculadora SOAP");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout( new BorderLayout());
        setSize( new Dimension(300, 400));
        setLocationRelativeTo( null);

        // Display donde aparecerán los números y resultados
        displayField = new JTextField();

        displayField.setEditable( false);
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        displayField.setPreferredSize(new Dimension(frmCliente.WIDTH, 50));
        displayField.setFont(new Font(displayField.getFont().getName(), Font.PLAIN, 20));

        add(displayField, BorderLayout.NORTH);

        // Panel para los botones de números y operaciones
        JPanel buttonPanel = new JPanel();

        buttonPanel.setLayout(
                new GridLayout(4, 4, 2, 2));
        String[] buttons = {
            "7", "8", "9", "+",
            "4", "5", "6", "-",
            "1", "2", "3", "*",
            "C", "0", "=", "/"
        };

        for (String b : buttons) {
            JButton button = new JButton(b);
            button.addActionListener((e) -> {

                this.buttonPressed(e);

            });
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);

        // Inicializar la operación y el resultado actual
        currentOperation = "";
        currentResult = 0;

        pack();

        setVisible(true);

    }

    private void buttonPressed(ActionEvent e) {
        String command = e.getActionCommand();

        if ("0123456789".contains(command)) {
            displayField.setText(displayField.getText() + command);
        } else if ("+-*/".contains(command)) {
            currentOperation = command;
            currentResult = Double.parseDouble(displayField.getText());
            displayField.setText("");
        } else if ("=".equals(command)) {
            performOperation();
        } else if ("C".equals(command)) {
            displayField.setText("");
            currentResult = 0;
            currentOperation = "";
        }
    }

    private void performOperation() {
        try {
            double number1 = currentResult;
            double number2 = Double.parseDouble(displayField.getText());
            switch (currentOperation) {
                case "+":
                    currentResult = calculadoraCliente.sumar((int) number1, (int) number2);
                    break;
                case "-":
                    currentResult = calculadoraCliente.restar((int) number1, (int) number2);

                    break;
                case "*":
                   currentResult = calculadoraCliente.multiplicar((int) number1, (int) number2);

                    break;
                case "/":
                    currentResult = calculadoraCliente.dividir((int) number1, (int) number2);

                    break;
            }
            displayField.setText(String.format("%.2f", currentResult)); // mostrar resultado con 2 decimales
            currentOperation = "";
        } catch (NumberFormatException ex) {
            displayField.setText("Error");
            currentResult = 0;
            currentOperation = "";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(frmCliente::new);
    }

}
