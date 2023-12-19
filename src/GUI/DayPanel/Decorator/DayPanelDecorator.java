package GUI.DayPanel.Decorator;

import GUI.DayPanel.DayPanel;

import javax.swing.border.LineBorder;
import java.awt.*;

public abstract class DayPanelDecorator {

    DayPanel dayPanel;
    Color background;
    Color foreground;

    public DayPanelDecorator( DayPanel dayPanel, Color background, Color foreground) {
        this.dayPanel = dayPanel;
        this.background = background;
        this.foreground = foreground;
        setColor();
    }

    void setColor(){
        dayPanel.setBackground(background);
        dayPanel.setBorder(new LineBorder(foreground, 1));
    }
}