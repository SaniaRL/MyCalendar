package GUI.Post;

import javax.swing.*;
import java.awt.*;

public class Post extends JButton {

    Category category;
    public Post(Category category){
        this.category = category;
    }

    public void buildPost(){
        setPreferredSize(new Dimension(200, 150));
        //TODO Update background
        setBackground(Color.GRAY);
    }
}