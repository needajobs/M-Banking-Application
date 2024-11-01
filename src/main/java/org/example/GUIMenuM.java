package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIMenuM extends JFrame implements ActionListener {
//untuk membuat frame dan panel pada Menu utama
    JFrame frame;
    JPanel mainPanel;
    JPanel menuBank;
    JPanel topMenu;
    loginConstructor lC;

    public GUIMenuM(loginConstructor lC) {
        this.frame = new JFrame();
        this.lC = lC;
//desain/bentuk dari panelnya
        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(92, 225, 230));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        topMenu = new JPanel();
        topMenu.setLayout(new GridLayout(1, 2));
        topMenu.setBackground(new Color(92, 225, 230));
        topMenu.setPreferredSize(new Dimension(600, 100));

        JPanel topLeft = new JPanel();
        topLeft.setLayout(new BoxLayout(topLeft, BoxLayout.LINE_AXIS));
        topLeft.setBackground(new Color(92, 225, 230));
        topLeft.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JLabel title = new JLabel("LIWEI HYPER BANK");
        ImageIcon logo = new ImageIcon("C:/Users/Li Wei/Desktop/UAS SMSTR4/UASFINAL/UAS_ALT/images/Logo.png");
        Image imgLogo = logo.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        ImageIcon resizedLogo = new ImageIcon(imgLogo);
        JLabel imageLabel = new JLabel(resizedLogo);

        topLeft.add(imageLabel);
        topLeft.add(title);
        topMenu.add(topLeft);

        JPanel topRight = new JPanel();
        topRight.setLayout(new GridBagLayout());
        topRight.setBackground(new Color(92, 225, 230));

        JButton logout = new JButton("Logout");
        logout.setFocusable(false);
        logout.setBackground(new Color(38, 74, 77));
        logout.setForeground(new Color(246, 246, 246));
        logout.addActionListener(this);
        logout.setActionCommand("out");
        topRight.add(logout);

        topMenu.add(topRight);


        //Panel Menu
        menuBank = new JPanel();
        menuBank.setBackground(new Color(29,41,81));
        menuBank.setLayout(new BoxLayout(menuBank, BoxLayout.LINE_AXIS));
        menuBank.setPreferredSize(new Dimension(600, 900));
        menuBank.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        mainPanel.add(topMenu);
        mainPanel.add(menuBank);

        JPanel menuSection = new JPanel();
        menuSection.setBackground(new Color(0,0,54));
        menuSection.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 10));
        menuBank.add(menuSection);

        //Food 1
        JPanel f1 = new JPanel();
        f1.setLayout(new BoxLayout(f1, BoxLayout.PAGE_AXIS));
        f1.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        //Panel Image
        JPanel fI1 = new JPanel(new GridBagLayout());
        ImageIcon image1 = new ImageIcon("C:/Users/Li Wei/Desktop/UAS SMSTR4/UASFINAL/UAS_ALT/images/transfer.png");
        Image img1 = image1.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        JButton imgF1 = new JButton(new ImageIcon(img1));
        imgF1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        imgF1.setFocusable(false);
        imgF1.setContentAreaFilled(false);
        imgF1.addActionListener(this);
        imgF1.setActionCommand("tfButton");
        //Panel Title
        JPanel fT1 = new JPanel(new GridBagLayout());
        JLabel ft1 = new JLabel("Transfer");
        ft1.setForeground(Color.WHITE);
        fT1.setOpaque(false);
        fT1.add(ft1);
        fI1.add(imgF1);
        f1.add(fI1);
        f1.add(fT1);
        f1.setOpaque(false);

        //Food 1
        JPanel f2 = new JPanel();
        f2.setLayout(new BoxLayout(f2, BoxLayout.PAGE_AXIS));
        f2.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        //Panel Image
        JPanel fI2 = new JPanel(new GridBagLayout());
        ImageIcon image2 = new ImageIcon("C:/Users/Li Wei/Desktop/UAS SMSTR4/UASFINAL/UAS_ALT/images/ceksaldo.png");
        Image img2 = image2.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);;
        JButton imgF2 = new JButton(new ImageIcon(img2));
        imgF2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        imgF2.setFocusable(false);
        imgF2.setContentAreaFilled(false);
        imgF2.addActionListener(this);
        imgF2.setActionCommand("saldoButton");
        //Panel Title
        JPanel fT2 = new JPanel(new GridBagLayout());
        JLabel ff2 = new JLabel("Cek Saldo");
        ff2.setForeground(Color.WHITE);
        fT2.setOpaque(false);
        fT2.add(ff2);
        fI2.add(imgF2);
        f2.add(fI2);
        f2.add(fT2);
        f2.setOpaque(false);

        //Food 1
        JPanel f3 = new JPanel();
        f3.setLayout(new BoxLayout(f3, BoxLayout.PAGE_AXIS));
        f3.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        //Panel Image
        JPanel fI3 = new JPanel(new GridBagLayout());
        ImageIcon image3 = new ImageIcon("C:/Users/Li Wei/Desktop/UAS SMSTR4/UASFINAL/UAS_ALT/images/mutasi.png");
        Image img3 = image3.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);;
        JButton imgF3 = new JButton(new ImageIcon(img3));
        imgF3.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        imgF3.setFocusable(false);
        imgF3.setContentAreaFilled(false);
        imgF3.addActionListener(this);
        imgF3.setActionCommand("mutasiButton");
        //Panel Title
        JPanel fT3 = new JPanel(new GridBagLayout());
        JLabel ff3 = new JLabel("Mutasi Rekening");
        ff3.setForeground(Color.WHITE);
        fT3.setOpaque(false);
        fT3.add(ff3);
        fI3.add(imgF3);
        f3.add(fI3);
        f3.add(fT3);
        f3.setOpaque(false);

        menuSection.add(f1);
        menuSection.add(f2);
        menuSection.add(f3);

        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Menu Utama");
        frame.setSize(650, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Untuk action button
        String ac = e.getActionCommand();
        if ("tfButton".equals(ac)) {
            GUITransfer GTF = new GUITransfer(lC);
        } else if ("saldoButton".equals((ac))) {
            GUICekSaldo cS = new GUICekSaldo(lC);
        } else if ("mutasiButton".equals(ac)) {
            GUIMutasi Mu = new GUIMutasi(lC);
            frame.dispose();
        } else if ("out".equals(ac)) {
            GUIlogin lg = new GUIlogin();
            frame.dispose();
        }
    }
}

