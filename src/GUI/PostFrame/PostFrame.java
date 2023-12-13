package GUI.PostFrame;

import GUI.FileManager;
import GUI.ColorSettings;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.time.LocalDate;

public class PostFrame extends JFrame {
    ColorSettings colorSettings;
    LocalDate date;
    ImageIcon icon;

    JPanel contentPanel;
    CreatePostPanel createPostPanel;

    public PostFrame(ColorSettings colorSettings){
        this.colorSettings = colorSettings;
        icon = new ImageIcon("Icons/7.png");
        contentPanel = new JPanel(new BorderLayout());

        createPostPanel = new CreatePostPanel(colorSettings, date);
    }

    public void buildFrame(LocalDate date){
        this.date = date;
        setSize(new Dimension(400, 600));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setIconImage(icon.getImage());
        setResizable(false);

        contentPanel.setVisible(true);
        createPostPanel.setVisible(true);

        CardLayout cardLayout = new CardLayout();
        contentPanel.setLayout(cardLayout);

        contentPanel.setBackground(colorSettings.getColor());
        contentPanel.add(createPostPanel, "CreatePostPanel");
        cardLayout.show(contentPanel, "CreatePostPanel");
        contentPanel.repaint();
        contentPanel.revalidate();

        add(contentPanel);

        setVisible(true);
    }
}