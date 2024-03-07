package bankproject.userinterface;

import bankproject.Account;
import bankproject.BankSystem;
import bankproject.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class MainPage extends JFrame {
    private JPanel MainPanel;
    private JButton loginMenuButton;
    private JButton aboutButton;
    private JButton exitButton;
    private JLabel docLabel;
    private JButton registerButton;

    public MainPage() {
        try {
            ObjectInputStream inp = new ObjectInputStream(new FileInputStream("BankData.dat"));
            BankSystem.accounts = (ArrayList<Account>) inp.readObject();
            BankSystem.clients = (ArrayList<Client>) inp.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        setContentPane(MainPanel);
        setTitle("BEST BANK 2024");
        setSize(750, 900);
        //frame.pack();
        setLocationRelativeTo(null); // Center the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        loginMenuButton.addActionListener(new loginMenuActionListener());
        aboutButton.addActionListener(new aboutActionListner());
        exitButton.addActionListener(new ExitActionListener());
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterPage clientRegistrationFrame = new RegisterPage();
                clientRegistrationFrame.setTitle("Login Page");
                clientRegistrationFrame.setSize(600, 300);
                clientRegistrationFrame.setLocationRelativeTo(null); // Center the frame
                clientRegistrationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                clientRegistrationFrame.setVisible(true);
            }
        });
    }


    private class aboutActionListner implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //setVisible(false);
            AboutPage aboutFrame = new AboutPage();
            aboutFrame.setTitle("About BANK OF IEDS");
            aboutFrame.setSize(750, 900);
            aboutFrame.setLocationRelativeTo(null); // Center the frame
            aboutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            aboutFrame.setVisible(true);
        }
        //awela was here
    }

    private class loginMenuActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            LoginPage LoginFrame = new LoginPage();
            LoginFrame.setTitle("Login Page");
            LoginFrame.setSize(600, 300);
            LoginFrame.setLocationRelativeTo(null); // Center the frame
            LoginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            LoginFrame.setVisible(true);
        }
    }

    private class ExitActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("BankData.dat"));
                out.writeObject(BankSystem.accounts);
                out.writeObject(BankSystem.clients);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            dispose();
        }
    }

    @Override
    public void setDefaultCloseOperation(int operation) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("BankData.dat"));
            out.writeObject(BankSystem.accounts);
            out.writeObject(BankSystem.clients);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        super.setDefaultCloseOperation(operation);
    }
}
