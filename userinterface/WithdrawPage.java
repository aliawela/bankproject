package bankproject.userinterface;

import bankproject.BankSystem;
import bankproject.CreditAccount;
import bankproject.DebitAccount;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WithdrawPage extends JFrame{
    private JPanel withdrawMainPanel;
    private JPasswordField secretCodePasswordField;
    private JTextField withdrawAmountTextField;
    private JButton cancelButton;
    private JButton confirmWithdrawlButton;

    public WithdrawPage() {
        setContentPane(withdrawMainPanel);
        confirmWithdrawlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(BankSystem.currentAccount instanceof DebitAccount){
                    if((Integer.valueOf(String.valueOf(secretCodePasswordField.getPassword())).equals(((DebitAccount)BankSystem.currentAccount).getSecretCode()))){
                        ((DebitAccount)BankSystem.currentAccount).Withdraw(Double.valueOf(withdrawAmountTextField.getText()));
                        setVisible(false);

                    }
                }else{
                    if((Integer.valueOf(String.valueOf(secretCodePasswordField.getPassword())).equals(((CreditAccount)BankSystem.currentAccount).getSecretCode()))){
                        ((CreditAccount)BankSystem.currentAccount).Withdraw(Double.valueOf(withdrawAmountTextField.getText()));
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
