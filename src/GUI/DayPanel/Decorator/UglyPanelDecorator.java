package GUI.DayPanel.Decorator;

import GUI.DayPanel.DayPanel;

import javax.swing.border.LineBorder;
import java.awt.*;

public class UglyPanelDecorator extends DayPanelDecorator {

    public UglyPanelDecorator(DayPanel dayPanel){
        super(dayPanel);
    }

    @Override
    public void setColor(){
        dayPanel.setBackground(new Color(255, 155, 185));
        dayPanel.setBorder(new LineBorder(new Color(187, 130, 57)));
    }
}
