package GUI.DayPanel.Decorator;

import GUI.DayPanel.DayPanel;

import javax.swing.border.LineBorder;
import java.awt.*;

public class PinkPanelDecorator extends DayPanelDecorator {

    public PinkPanelDecorator(DayPanel dayPanel){
        super(dayPanel);
        setColor();
    }

    @Override
    public void setColor(){
        dayPanel.setBackground(new Color(255, 155, 185));
        dayPanel.setBorder(new LineBorder(new Color(120, 30, 50)));
    }

}
