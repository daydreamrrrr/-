package lab21;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class WindowsButton implements Button {

    private JButton button;

    @Override
    public void render(JPanel panel) {
        button = new JButton("Button 1");
        button.setBackground(new Color(169, 169, 169));
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setFocusPainted(false);
        panel.add(button);
    }

    @Override
    public void onClick() {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button 1 was clicked.");
            }
        });
    }
}
