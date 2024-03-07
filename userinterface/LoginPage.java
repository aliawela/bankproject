package bankproject.userinterface;

import bankproject.BankSystem;
import bankproject.CreditAccount;
import bankproject.DebitAccount;
import bankproject.exceptions.CardDoesntExistException;
import bankproject.exceptions.WrongSecretCodeException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame{
    private JPanel loginPanel;
    private JButton loginButton;
    private JButton cancelButton;
    private JRadioButton creditradioButton;
    private JRadioButton debitradioButton;
    private JTextField cardnumberTextField;
    private JLabel cardnumberLabel;
    private JLabel secretCodeLabel;
    private JPasswordField secretCodePasswordField;
    Boolean cardType;
    Boolean accountCreated = false;

    public LoginPage() throws HeadlessException {
        this.setContentPane(loginPanel);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0;i< BankSystem.accounts.size();i++) {
                    if (cardType) {
                        if (((CreditAccount)BankSystem.accounts.get(i)).getCcNum().equals(cardnumberTextField.getText())){
                            System.out.println(((CreditAccount)BankSystem.accounts.get(i)).getSecretCode());
                            if(Integer.valueOf(String.valueOf(secretCodePasswordField.getPassword())).equals(((CreditAccount)(BankSystem.accounts.get(i))).getSecretCode())){
                                BankSystem.currentAccount = (CreditAccount)BankSystem.accounts.get(i);
                                UserPage userPage = new UserPage();
                                userPage.setTitle("Login Page");
                                userPage.setSize(600, 300);
                                userPage.setLocationRelativeTo(null); // Center the frame
                                userPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                userPage.setVisible(true);
                                setVisible(false);
                                accountCreated = true;
                                break;
                            }else{
                                try {
                                    throw new WrongSecretCodeException();
                                } catch (WrongSecretCodeException ex) {
                                    ex.printStackTrace();
                                }
                            }
                        }
                    }else{
                        if((Integer.valueOf(String.valueOf(secretCodePasswordField.getPassword())).equals(((DebitAccount)(BankSystem.accounts.get(i))).getSecretCode()))){
                            BankSystem.currentAccount = (CreditAccount)BankSystem.accounts.get(i);
                            UserPage userPage = new UserPage();
                            userPage.setTitle("User Page");
                            userPage.setSize(600, 300);
                            userPage.setLocationRelativeTo(null); // Center the frame
                            userPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            userPage.setVisible(true);
                            setVisible(false);
                            break;

                        }else{
                            try {
                                throw new WrongSecretCodeException();
                            } catch (WrongSecretCodeException ex) {
                                ex.printStackTrace();
                            }
                    }
                }
            }
                if(!accountCreated){
                    try {
                        throw new CardDoesntExistException();
                    } catch (CardDoesntExistException ex) {
                        ex.printStackTrace();
                    }
                }

            }});

        debitradioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardType = false;
            }
        });
        creditradioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardType = true;
            }
        });
    }
    public void setDefaultCloseOperation(int operation) {
        setVisible(false);
    }
}
