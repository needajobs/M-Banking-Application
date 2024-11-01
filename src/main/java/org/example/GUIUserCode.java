package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIUserCode extends JFrame implements ActionListener {

    JFrame frame;
    JPanel panel;

    JPasswordField code;

    GUIlogin gLog;

    loginConstructor lC;


    public GUIUserCode(GUIlogin guiLogin, loginConstructor lC) {
        this.frame = new JFrame();
        this.gLog = guiLogin;
        this.lC = new loginConstructor(); // Initialize lC here

        //Membuat Panel
        panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(92, 225, 230));
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.fill = GridBagConstraints.HORIZONTAL; // Allow horizontal resizing
        constraints.weightx = 0.5; // Allow the text field to grow in width

        // Menambahkan gambar ke dalam JFrame
        JLabel inputkode = new JLabel("Masukkan Kode Akses : ");
        constraints.gridy = 0;
        panel.add(inputkode, constraints);

        //Membuat Button Order
        code = new JPasswordField();
        code.setEditable(true);
        code.setFocusable(true);
        code.setHorizontalAlignment(SwingConstants.CENTER);
        code.setBackground(new Color(246,246,246));
        code.setFont(new Font("", Font.BOLD, 14));

        JButton mEnter = new JButton("Login");
        mEnter.setFocusable(false);
        mEnter.setBackground(new Color(38, 74, 77));
        mEnter.setForeground(new Color(246, 246, 246));
        mEnter.setPreferredSize(new Dimension(200, 30));
        mEnter.addActionListener(this);
        mEnter.setActionCommand("entLog");

        constraints.gridy = 1; // Set the position for the first button
        panel.add(code, constraints);

        constraints.gridy = 2; // Set the position for the second button
        panel.add(mEnter,constraints);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Menu Kode Akses");
        frame.setSize(300, 200);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        queryDB lDB = new queryDB();
        //Untuk action button
        String ac = e.getActionCommand();

        if ("entLog".equals(ac)){
            if (lDB.cekLogin(code.getText())) {

                new GUIMenuM(lC);
                frame.dispose();
                gLog.frame.dispose();
                lC.setUserCode(code.getText());
            } else if (!lDB.cekLogin(code.getText())) {
                JOptionPane.showMessageDialog(frame, "Kode Akses Yang Anda Masukkan Salah!!!", "Kode Akses Tidak Valid", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
