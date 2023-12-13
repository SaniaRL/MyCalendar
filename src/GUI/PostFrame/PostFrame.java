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
    DayViewPanel dayViewPanel;
    CreatePostPanel createPostPanel;

    CardLayout cardLayout;
/*    DayViewPanelParent dayViewPanelParent = () -> {
        cardLayout.show(contentPanel, "CreatePost");
        contentPanel.repaint();
        contentPanel.revalidate();
    };

 */

    public PostFrame(ColorSettings colorSettings, LocalDate date){
        this.colorSettings = colorSettings;
        this.date = date;
        icon = new ImageIcon("Icons/7.png");
        contentPanel = new JPanel(new BorderLayout());


        dayViewPanel = new DayViewPanel(colorSettings, date, () -> {
            cardLayout.show(contentPanel, "CreatePost");
            contentPanel.repaint();
            contentPanel.revalidate();
        });

        createPostPanel = new CreatePostPanel(colorSettings, date);
        cardLayout = new CardLayout();
    }

    public void buildFrame(){
        setSize(new Dimension(400, 600));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setIconImage(icon.getImage());
        setResizable(false);

        contentPanel.setVisible(true);
//        contentPanel.setBackground(colorSettings.getColor());

        createPostPanel.setVisible(true);

        contentPanel.setLayout(cardLayout);
        contentPanel.add(dayViewPanel, "DayView");
        contentPanel.add(createPostPanel, "CreatePost");
        cardLayout.show(contentPanel, "DayView");
        contentPanel.repaint();
        contentPanel.revalidate();

        add(contentPanel);

        setVisible(true);
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}