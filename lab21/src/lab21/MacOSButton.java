package lab21;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MacOSButton implements Button {

    private JButton button;

    @Override
    public void render(JPanel panel) {
        button = new JButton("Button 2");
        button.setBackground(new Color(192, 192, 192));
        button.setFont(new Font("Helvetica", Font.BOLD, 16));
        button.setFocusPainted(false);
        panel.add(button);
    }

    @Override
    public void onClick() {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button 2 was clicked.");
            }
        });
    }
}
