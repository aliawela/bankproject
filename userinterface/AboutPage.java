package bankproject.userinterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AboutPage extends JFrame {
    private JPanel aboutMainPanel;
    private JLabel aboutLabel2;
    private JLabel aboutLabel1;
    private JLabel aboutLabel3;
    private JButton backButton;
    private JLabel aboutHeaderLabel;

    public AboutPage() throws HeadlessException {
        setContentPane(aboutMainPanel);
        setTitle("BEST BANK 2024");
        setSize(750, 900);
        pack();
        setLocationRelativeTo(null); // Center the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
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
