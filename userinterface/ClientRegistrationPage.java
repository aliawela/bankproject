package bankproject.userinterface;

import bankproject.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientRegistrationPage extends JFrame{
    private JPanel clientRegistrationPanel;
    private JTextField nameTextField;
    private JTextField phoneTextField;
    private JTextField ssnTextField;
    private JTextField addressTextField;
    private JButton createButton;
    private JButton backButton;

    public ClientRegistrationPage() {
        setContentPane(clientRegistrationPanel);
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client c = new Client(nameTextField.getText(),Integer.valueOf(ssnTextField.getText()),phoneTextField.getName(),addressTextField.getText());
                setVisible(false);
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }

    @Override
    public void setDefaultCloseOperation(int operation) {
        setVisible(false);
    }
}
