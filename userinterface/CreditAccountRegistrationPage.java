package bankproject.userinterface;

import bankproject.BankSystem;
import bankproject.Client;
import bankproject.CreditAccount;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreditAccountRegistrationPage extends JFrame{
    private JPanel creditAccountRegistrationPanel;
    private JTextField ccNumberTextField;
    private JButton backButton;
    private JButton registerButton;
    private JTextField typeTextField;
    private JTextField secretCodeTextField;
    private JTextField payLimitTextField;
    private JTextField payBackTextField;
    private JTextField withdrawalTextField;
    private JTextField clientNameTextField;

    public CreditAccountRegistrationPage() {
        setContentPane(creditAccountRegistrationPanel);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client c1 = null;
                for(int i =0;i< BankSystem.clients.size();i++){
                    if(BankSystem.clients.get(i).getName().equalsIgnoreCase(clientNameTextField.getText())){
                        c1 = BankSystem.clients.get(i);
                        break;
                    }
                }
                if(c1 != null){
                    CreditAccount creditAccount1 = new CreditAccount(c1,00.00, Double.valueOf(withdrawalTextField.getText()), ccNumberTextField.getText(), typeTextField.getText(),Integer.valueOf(secretCodeTextField.getText()),Double.valueOf(payLimitTextField.getText()),Double.valueOf(payBackTextField.getText()));
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
