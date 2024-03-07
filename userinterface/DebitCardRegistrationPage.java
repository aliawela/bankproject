package bankproject.userinterface;

import bankproject.BankSystem;
import bankproject.Client;
import bankproject.CreditAccount;
import bankproject.DebitAccount;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DebitCardRegistrationPage extends JFrame{
    private JPanel debitCardRegistrationPanel;
    private JTextField ccNumberTextField;
    private JTextField typeTextField;
    private JTextField secretCodeTextField;
    private JTextField countryCodeTextField;
    private JTextField payBackTextField;
    private JTextField withdrawalTextField;
    private JTextField clientNameTextField;
    private JButton registerButton;
    private JButton backButton;

    public DebitCardRegistrationPage() {
        setContentPane(debitCardRegistrationPanel);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client c1 = null;
                for(int i = 0; i< BankSystem.clients.size(); i++){
                    if(BankSystem.clients.get(i).getName().equalsIgnoreCase(clientNameTextField.getText())){
                        c1 = BankSystem.clients.get(i);
                        break;
                    }
                }
                if(c1 != null){
                    DebitAccount debitAccount1 = new DebitAccount(c1,00.00, Double.valueOf(withdrawalTextField.getText()),countryCodeTextField.getText(),ccNumberTextField.getText() ,Integer.valueOf(secretCodeTextField.getText()),typeTextField.getText(),Double.valueOf(payBackTextField.getText()));
                    setVisible(false);
                }
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
