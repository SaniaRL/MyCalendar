package GUI.Post.FileManaging;

import GUI.ColorSettings;

import javax.swing.*;
import java.awt.*;

public class PostFrame extends JFrame {
    ColorSettings colorSettings;

    public PostFrame(ColorSettings colorSettings){
        this.colorSettings = colorSettings;
        buildFrame();
    }

    public void buildFrame(){
        setSize(new Dimension(300, 500));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
