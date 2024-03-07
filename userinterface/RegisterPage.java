package bankproject.userinterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPage extends JFrame{
    private JPanel registerMainPanel;
    private JButton backButton;
    private JButton debitAccountButton;
    private JButton creditAccountButton;
    private JButton clientButton;

    public RegisterPage() {
        setContentPane(registerMainPanel);
        clientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientRegistrationPage clientRegistrationFrame = new ClientRegistrationPage();
                clientRegistrationFrame.setTitle("Client Registration Page");
                clientRegistrationFrame.setSize(600, 300);
                clientRegistrationFrame.setLocationRelativeTo(null); // Center the frame
                clientRegistrationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                clientRegistrationFrame.setVisible(true);
            }
        });
        creditAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               CreditAccountRegistrationPage CreditRegistrationFrame = new CreditAccountRegistrationPage();
                CreditRegistrationFrame.setTitle("Credit Account Registration Page");
                CreditRegistrationFrame.setSize(600, 400);
                CreditRegistrationFrame.setLocationRelativeTo(null); // Center the frame
                CreditRegistrationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                CreditRegistrationFrame.setVisible(true);
            }
        });
        debitAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DebitCardRegistrationPage debitCardRegistrationFrame = new DebitCardRegistrationPage();
                debitCardRegistrationFrame.setTitle("Debit Account Registration Page");
                debitCardRegistrationFrame.setSize(600, 400);
                debitCardRegistrationFrame.setLocationRelativeTo(null); // Center the frame
                debitCardRegistrationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                debitCardRegistrationFrame.setVisible(true);
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
