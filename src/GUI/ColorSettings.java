package GUI;

import javax.swing.*;
import java.awt.*;

public class ColorSettings {
    private Color color;
    private Color todayBackgroundColor;
    private Color todayForegroundColor;
    private Color weekdayBackgroundColor;
    private Color weekdayForegroundColor;
    private Color weekendBackgroundColor;
    private Color weekendForegroundColor;
    private Color emptyBackgroundColor;
    private Color emptyForegroundColor;
    private Color borderColor;

    public ColorSettings(){
        setGreenColorScheme();
    }

    public void setColorScheme(String color){
        switch(color.toLowerCase()){
            case "ugly" -> setUglyColorScheme();
            case "green" -> setGreenColorScheme();
            case "pink" -> setPinkColorScheme();
            default -> setDefaultColorScheme();
        }
    }

    public void setDefaultColorScheme(){
        color = Color.white;
        todayBackgroundColor = new Color(100, 255, 100);
        todayForegroundColor = new Color(0, 40, 0);
        weekdayBackgroundColor = Color.WHITE;
        weekdayForegroundColor = Color.BLACK;
        weekendBackgroundColor = new Color(255, 166, 166);
        weekendForegroundColor = new Color(233, 30, 30);
        emptyBackgroundColor = Color.lightGray;
        emptyForegroundColor = Color.gray;
        borderColor = Color.gray;
    }

    public void setGreenColorScheme(){
        color = new Color(170, 255, 170);
        todayBackgroundColor = new Color(100, 255, 100);
        todayForegroundColor = new Color(0, 40, 0);
        weekdayBackgroundColor = new Color(176, 255, 176);
        weekdayForegroundColor = new Color(33, 130, 30);
        weekendBackgroundColor = new Color(33, 130, 30);
        weekendForegroundColor = new Color(13, 55, 13);
        emptyBackgroundColor = new Color(120, 200, 120);
        emptyForegroundColor = new Color(130, 190, 130);
        borderColor = new Color(10, 35, 10);
    }

    public void setPinkColorScheme(){
        color = Color.white;
        todayBackgroundColor = new Color(100, 255, 100);
        todayForegroundColor = new Color(0, 40, 0);
        weekdayBackgroundColor = Color.CYAN;
        weekdayForegroundColor = Color.pink;
        weekendBackgroundColor = new Color(145, 16, 166);
        weekendForegroundColor = new Color(33, 130, 30);
        emptyBackgroundColor = Color.yellow;
        emptyForegroundColor = Color.blue;
        borderColor = Color.orange;
    }

    public void setUglyColorScheme(){
        color = Color.green;
        todayBackgroundColor = new Color(100, 255, 100);
        todayForegroundColor = new Color(0, 40, 0);
        weekdayBackgroundColor = Color.CYAN;
        weekdayForegroundColor = Color.pink;
        weekendBackgroundColor = new Color(145, 16, 166);
        weekendForegroundColor = new Color(33, 130, 30);
        emptyBackgroundColor = Color.yellow;
        emptyForegroundColor = Color.blue;
        borderColor = Color.orange;
    }

    public Color getTodayBackgroundColor() {
        return todayBackgroundColor;
    }

    public Color getTodayForegroundColor() {
        return todayForegroundColor;
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

    public Color getColor() {
        return color;
    }
}
