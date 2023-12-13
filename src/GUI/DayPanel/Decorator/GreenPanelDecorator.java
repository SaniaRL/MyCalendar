package GUI.DayPanel.Decorator;

import GUI.DayPanel.DayPanel;

import javax.swing.border.LineBorder;
import java.awt.*;

public class GreenPanelDecorator extends DayPanelDecorator {

    public GreenPanelDecorator(DayPanel dayPanel){
        super(dayPanel);
        setColor();
    }

    @Override
    public void setColor(){
        dayPanel.setBackground(new Color(10, 240, 10));
        dayPanel.setBorder(new LineBorder(new Color(10, 200, 10)));
    }
}
