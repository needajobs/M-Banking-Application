package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
    public class GUIlogin extends JFrame implements ActionListener {

        JFrame frame;
        JPanel panel;
        loginConstructor lC;

        public GUIlogin() {
            this.frame = new JFrame();
            this.lC = lC; // Set lC from the passed parameter

            //Membuat Panel
            panel = new JPanel(new GridBagLayout());
            panel.setBackground(new Color(92, 225, 230));
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.insets = new Insets(0, 10, 10, 10);

            // Menambahkan gambar ke dalam JFrame
            ImageIcon logo = new ImageIcon("C:/Users/Li Wei/Desktop/UAS SMSTR4/UASFINAL/UAS_ALT/images/Logo.png");
            Image img1 = logo.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            ImageIcon resizedLogo = new ImageIcon(img1);
            JLabel imageLabel = new JLabel(resizedLogo);
            constraints.gridy = 0;
            panel.add(imageLabel, constraints);

            //Membuat Button Order
            JButton mLogin = new JButton("LOGIN TO ACCOUNT");
            mLogin.setFocusable(false);
            mLogin.setBackground(new Color(38, 74, 77));
            mLogin.setForeground(new Color(246, 246, 246));
            mLogin.setPreferredSize(new Dimension(200, 30));
            mLogin.addActionListener(this);
            mLogin.setActionCommand("mLog");

            constraints.gridy = 1; // Set the position for the first button
            panel.add(mLogin, constraints);

            frame.add(panel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Menu Login");
            frame.setSize(600, 600);
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            //Untuk action button
            String ac = e.getActionCommand();
            if ("mLog".equals(ac)) {
                GUIUserCode userCodelog= new GUIUserCode(GUIlogin.this, lC);
                //Membuka GUIMenuTab Dan Menutup GUIAwal
            }
        }
    }
