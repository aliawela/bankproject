package bankproject.userinterface;

import bankproject.BankSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class UserPage extends JFrame {
    private JPanel userPanel;
    private JPanel balancePanel;
    private JPanel mainActionsPanel;
    private JLabel currentBalance;
    private JButton WITHDRAWButton;
    private JButton VIEWPREVIOUSTRANSACTIONSButton;
    private JButton PAYButton;
    private JButton TRANSFERButton;
    private JButton DEPOSITEButton;
    private JLabel clientName;

    public UserPage() {
        currentBalance.setText(String.valueOf(BankSystem.currentAccount.getBalance()));
        clientName.setText(BankSystem.currentAccount.getClient().getName());//wael was here
        setContentPane(userPanel);



        WITHDRAWButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WithdrawPage withdrawPage = new WithdrawPage();
                withdrawPage.setTitle("Withdraw Page");
                withdrawPage.setSize(600, 300);
                withdrawPage.setLocationRelativeTo(null); // Center the frame
                withdrawPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                withdrawPage.setVisible(true);
            }
        });
        DEPOSITEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DepositePage depositePage = new DepositePage();
                depositePage.setTitle("Deposite Page");
                depositePage.setSize(600, 300);
                depositePage.setLocationRelativeTo(null); // Center the frame
                depositePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                depositePage.setVisible(true);
            }
        });
        TRANSFERButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TransferPage transferPage = new TransferPage();
                transferPage.setTitle("Transfer Page");
                transferPage.setSize(600, 300);
                transferPage.setLocationRelativeTo(null); // Center the frame
                transferPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                transferPage.setVisible(true);

            }
        });
        PAYButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PayPage payPage = new PayPage();
                payPage.setTitle("Pay Page");
                payPage.setSize(600, 300);
                payPage.setLocationRelativeTo(null); // Center the frame
                payPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                payPage.setVisible(true);
            }
        });
        VIEWPREVIOUSTRANSACTIONSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TransactionHistoryPage transactionHistoryPage = new TransactionHistoryPage();
                transactionHistoryPage.setTitle("Pay Page");
                transactionHistoryPage.setSize(900, 1200);
                transactionHistoryPage.setLocationRelativeTo(null); // Center the frame
                transactionHistoryPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                transactionHistoryPage.setVisible(true);
            }
        });
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {

            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent event) {
                setCurrentBalance();
            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });


    }
    public void setDefaultCloseOperation(int operation) {
        for(int i = 0;i<BankSystem.accounts.size();i++){
            if(BankSystem.accounts.get(i).getClient().getName().equals(BankSystem.currentAccount.getClient().getName())){
                BankSystem.accounts.set(i,BankSystem.currentAccount);
                break;
            }
        }
        setVisible(false);
    }

    public void setCurrentBalance() {
        currentBalance.setText(String.valueOf(BankSystem.currentAccount.getBalance()));
    }
}
