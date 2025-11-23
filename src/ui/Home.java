package ui;

import java.swing.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Home extends JFrame {
    public Home() {
        setTitle("Restoran Abdul");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Ini halaman Home UI"));
        panel.add(new JButton("Lanjutkan"));
        add(panel);

        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void switchPanel(JPanel panelBaru) {
        setContentPane(panelBaru);
        revalidate();
        repaint();
    }
}
