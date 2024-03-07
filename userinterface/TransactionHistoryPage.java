package bankproject.userinterface;

import bankproject.BankSystem;
import bankproject.TransactionType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TransactionHistoryPage extends JFrame {
    Boolean payFilter = true;
    Boolean depositeFilter = true;
    Boolean withdrawFilter = true;
    Boolean transferFilter = true;

    private JPanel transactionHistoryMainPanel;
    private JPanel filterPanel;
    private JPanel listPanel;
    private JComboBox dayFromComboBox;
    private JComboBox monthFromComboBox;
    private JComboBox yearFromComboBox;
    private JComboBox dayToComboBox;
    private JComboBox monthToComboBox;
    private JComboBox yearToComboBox;
    private JCheckBox depositeCheckBox;
    private JCheckBox transferCheckBox;
    private JCheckBox payCheckBox;
    private JButton applyFilterButton;
    private JCheckBox withdrawCheckBox;
    private JTextArea displayTextArea;
    private JScrollPane displayScrollPanel;

    public TransactionHistoryPage() {
        setContentPane(transactionHistoryMainPanel);
        applyFilterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayTextArea.setText("");
                payFilter = payCheckBox.isSelected();
                depositeFilter = depositeCheckBox.isSelected();
                transferFilter = transferCheckBox.isSelected();
                withdrawFilter = withdrawCheckBox.isSelected();

                int selectedIndex = Integer.parseInt((String)monthFromComboBox.getSelectedItem());
                int selectedIndex2 = Integer.parseInt((String)yearFromComboBox.getSelectedItem());
                int selectedIndex3 = Integer.parseInt((String)dayFromComboBox.getSelectedItem());
                LocalDate d1 = LocalDate.of(selectedIndex2, selectedIndex, selectedIndex3);
                int selectedIndex1 = Integer.parseInt((String)monthToComboBox.getSelectedItem());
                int selectedIndex4 = Integer.parseInt((String)yearToComboBox.getSelectedItem());
                int selectedIndex5 = Integer.parseInt((String)dayToComboBox.getSelectedItem());
                LocalDate d2 = LocalDate.of(selectedIndex4, selectedIndex1, selectedIndex5);
                BankSystem.currentAccount.displayTransDates(d1, d2);
                for (int i = 0; i < BankSystem.transactions.size(); i++) {
                    if (!payFilter && BankSystem.transactions.get(i).getType() == TransactionType.PAY) {
                        BankSystem.transactions.remove(i);
                    }
                    if (!transferFilter && BankSystem.transactions.get(i).getType() == TransactionType.TRANSFER) {
                        BankSystem.transactions.remove(i);
                    }
                    if (!depositeFilter && BankSystem.transactions.get(i).getType() == TransactionType.DEPOSIT) {
                        BankSystem.transactions.remove(i);
                    }
                    if (!withdrawFilter && BankSystem.transactions.get(i).getType() == TransactionType.WITHDRAW) {
                        BankSystem.transactions.remove(i);
                    }
                }
                displayTextArea.append(BankSystem.transactions.toString());


            }


        });
    }

    @Override
    public void setDefaultCloseOperation(int operation) {
        setVisible(false);
    }
}
