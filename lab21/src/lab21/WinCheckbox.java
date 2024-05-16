package lab21;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class WinCheckbox implements Checkbox {

    JCheckBox checkbox = new JCheckBox("Windows Checkbox");

    @Override
    public void render(JPanel panel) {
        checkbox.setBackground(new Color(169, 169, 169));
        checkbox.setForeground(Color.BLACK);
        checkbox.setFont(new Font("Arial", Font.BOLD, 16));
        checkbox.setFocusPainted(false);
        checkbox.setBorderPainted(false);
        checkbox.setContentAreaFilled(false);
        checkbox.setOpaque(true);
        panel.add(checkbox);

    }

    @Override
    public void onSelect() {
        checkbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Windows checkbox selected: " + checkbox.isSelected());
            }
        });
    }

}
