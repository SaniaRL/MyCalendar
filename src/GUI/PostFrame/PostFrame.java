package GUI.PostFrame;

import GUI.ColorSettings;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class PostFrame extends JFrame {
    ColorSettings colorSettings;
    LocalDate date;
    ImageIcon icon;

    JPanel contentPanel;
    CreatePostPanel createPostPanel;

    public PostFrame(ColorSettings colorSettings, LocalDate date){
        this.colorSettings = colorSettings;
        this.date = date;
        icon = new ImageIcon("Icons/7.png");
        contentPanel = new JPanel(new BorderLayout());

        createPostPanel = new CreatePostPanel(colorSettings, date);
    }

    public void buildFrame(){
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

    public void setDate(LocalDate date) {
        this.date = date;
    }
}