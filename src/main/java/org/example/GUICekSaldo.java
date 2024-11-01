package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;

public class GUICekSaldo extends JFrame implements ActionListener {

    JFrame frame;
    JPanel panel;
    GUIMenuM gMen;
    loginConstructor lC;
    queryDB lDB = new queryDB();

    String userCode;

    public GUICekSaldo(loginConstructor lC) {
        this.frame = new JFrame();
        this.lC = new loginConstructor();

        userCode = lC.getUserCode();

        //Membuat Panel
        panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(92, 225, 230));
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0.5;

        JLabel rek = new JLabel("Total Saldo Anda : ");

        JLabel tf = new JLabel();
        Locale localeID = new Locale("id", "ID");
        NumberFormat rupiahFormat = NumberFormat.getCurrencyInstance(localeID);
        String formattedValue = rupiahFormat.format(lDB.getSaldo(lDB.noRekUser(userCode)));
        tf.setText(formattedValue);

        JButton mEnter = new JButton("Done");
        mEnter.setFocusable(false);
        mEnter.setBackground(new Color(38, 74, 77));
        mEnter.setForeground(new Color(246, 246, 246));
        mEnter.setPreferredSize(new Dimension(200, 30));
        mEnter.addActionListener(this);
        mEnter.setActionCommand("entLog");

        constraints.gridy = 1;
        panel.add(rek, constraints);

        constraints.gridy = 2;
        panel.add(tf, constraints);

        constraints.gridy = 3;
        panel.add(mEnter, constraints);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Menu Cek Saldo");
        frame.setSize(300, 200);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Untuk action button
        String ac = e.getActionCommand();

        if ("entLog".equals(ac)){
            frame.dispose();
        }
    }
}


