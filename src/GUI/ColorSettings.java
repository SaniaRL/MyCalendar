package GUI;

import javax.swing.*;
import java.awt.*;

public class ColorSettings {
    private Color color;
    private Color weekdayBackgroundColor;
    private Color weekdayForegroundColor;
    private Color weekendBackgroundColor;
    private Color weekendForegroundColor;
    private Color emptyBackgroundColor;
    private Color emptyForegroundColor;
    private Color borderColor;
    private String path;
    private Image background = new ImageIcon().getImage();


    public ColorSettings(){
        color = Color.BLACK;
        weekdayBackgroundColor = Color.WHITE;
        weekdayForegroundColor = Color.BLACK;
        weekendBackgroundColor = new Color(255, 166, 166);
        weekendForegroundColor = new Color(233, 30, 30);
        emptyBackgroundColor = Color.lightGray;
        emptyForegroundColor = Color.gray;
        path = "Backgrounds/blackBackground.png";

        borderColor = Color.gray;
    }

    public void setDefaultColorScheme(){
        weekdayBackgroundColor = Color.lightGray;
        borderColor = Color.BLACK;


    }
    public void setUglyColorScheme(){
        weekdayBackgroundColor = Color.green;
        borderColor = Color.pink;

    }

    public Color getWeekdayBackgroundColor() {
        return weekdayBackgroundColor;
    }

    public Color getWeekendBackgroundColor() {
        return weekendBackgroundColor;
    }

    public Color getWeekendForegroundColor() {
        return weekendForegroundColor;
    }

    public Color getEmptyBackgroundColor() {
        return emptyBackgroundColor;
    }

    public Color getWeekdayForegroundColor() {
        return weekdayForegroundColor;
    }

    public Color getEmptyForegroundColor() {
        return emptyForegroundColor;
    }

    public Color getBorderColor() {
        return borderColor;
    }
}
