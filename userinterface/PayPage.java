package bankproject.userinterface;

import bankproject.Account;
import bankproject.BankSystem;
import bankproject.CreditAccount;
import bankproject.DebitAccount;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PayPage extends JFrame{
    private JPanel PayMainPanel;
    private JPasswordField secretCodePasswordField;
    private JTextField paymentAmountTextField;
    private JButton confirmPaymentButton;
    private JButton cancelButton;
    private JTextField paymentAccountTextField;
    private JTextField countryCodeTextField;

    public PayPage() {
        setContentPane(PayMainPanel);
        confirmPaymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Account temp;
                for(int i = 0; i< BankSystem.accounts.size(); i++){
                    if(BankSystem.accounts.get(i).getClient().getName().equalsIgnoreCase(paymentAccountTextField.getText())){
                        temp = BankSystem.accounts.get(i);
                        if(BankSystem.currentAccount instanceof DebitAccount){
                            if((Integer.valueOf(String.valueOf(secretCodePasswordField.getPassword())).equals(((DebitAccount)BankSystem.currentAccount).getSecretCode()))){
                                ((DebitAccount)BankSystem.currentAccount).Pay(Double.valueOf(paymentAmountTextField.getText()),Integer.valueOf(String.valueOf(secretCodePasswordField.getPassword())),((DebitAccount) BankSystem.currentAccount).getDebitCardNum(),temp,countryCodeTextField.getText());

                            }
                        }else{
                            if((Integer.valueOf(String.valueOf(secretCodePasswordField.getPassword())).equals(((CreditAccount)BankSystem.currentAccount).getSecretCode()))){
                                ((CreditAccount)BankSystem.currentAccount).Pay(Double.valueOf(paymentAmountTextField.getText()),Integer.valueOf(String.valueOf(secretCodePasswordField.getPassword())),((CreditAccount)BankSystem.currentAccount).getCcNum(),temp,countryCodeTextField.getText());
                                setVisible(false);
                            }
                        }
                        break;
                    }
                }
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }
    private void setDefaultCloseOperation() {
        setVisible(false);
    }
}
