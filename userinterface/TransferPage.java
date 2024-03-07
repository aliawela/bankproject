package bankproject.userinterface;

import bankproject.Account;
import bankproject.BankSystem;
import bankproject.CreditAccount;
import bankproject.DebitAccount;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransferPage extends JFrame{
    private JPasswordField secretCodePasswordField;
    private JTextField transferAmountTextField;
    private JButton confirmTransferButton;
    private JButton cancelButton;
    private JTextField accountNameTextField;
    private JPanel transferMainPanel;

    public TransferPage() {
        setContentPane(transferMainPanel);

        confirmTransferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Account temp;
                for(int i = 0;i<BankSystem.accounts.size();i++){
                    if(BankSystem.accounts.get(i).getClient().getName().equalsIgnoreCase(accountNameTextField.getText())){
                        temp = BankSystem.accounts.get(i);
                        if(BankSystem.currentAccount instanceof DebitAccount ){
                            if((Integer.valueOf(String.valueOf(secretCodePasswordField.getPassword())).equals(((DebitAccount)BankSystem.currentAccount).getSecretCode()))){
                                BankSystem.currentAccount.Transfer(temp, Double.valueOf(transferAmountTextField.getText()));

                            }
                        }else{
                            if((Integer.valueOf(String.valueOf(secretCodePasswordField.getPassword())).equals(((CreditAccount)BankSystem.currentAccount).getSecretCode()))){
                                BankSystem.currentAccount.Transfer(temp, Double.valueOf(transferAmountTextField.getText()));
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
