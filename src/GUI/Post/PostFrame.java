package GUI.Post;

import GUI.ColorSettings;

import javax.swing.*;
import java.awt.*;

public class PostFrame extends JFrame {
    ColorSettings colorSettings;
    ImageIcon icon;

    public PostFrame(ColorSettings colorSettings){
        this.colorSettings = colorSettings;
        icon = new ImageIcon("Icons/calendar.png");
    }

    public void buildFrame(){
        setSize(new Dimension(300, 500));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setIconImage(icon.getImage());
        setVisible(true);
    }
}