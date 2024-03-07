package bankproject.userinterface;

import bankproject.BankSystem;
import bankproject.CreditAccount;
import bankproject.DebitAccount;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepositePage extends JFrame{
    private JPanel depositeMainPanel;
    private JPasswordField secretCodePasswordField;
    private JTextField depositeAmountTextField;
    private JButton cancelButton;
    private JButton confirmDepositeButton;

    public DepositePage() {
        setContentPane(depositeMainPanel);

        confirmDepositeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(BankSystem.currentAccount instanceof DebitAccount){
                    if((Integer.valueOf(String.valueOf(secretCodePasswordField.getPassword())).equals(((DebitAccount)BankSystem.currentAccount).getSecretCode()))){
                        ((DebitAccount)BankSystem.currentAccount).Deposit(Double.valueOf(depositeAmountTextField.getText()));
                        setVisible(false);

                    }
                }else{
                    if((Integer.valueOf(String.valueOf(secretCodePasswordField.getPassword())).equals(((CreditAccount)BankSystem.currentAccount).getSecretCode()))){
                        ((CreditAccount)BankSystem.currentAccount).Deposit(Double.valueOf(depositeAmountTextField.getText()));
                        setVisible(false);
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
