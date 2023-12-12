package GUI.DayPanel.Decorator;

import GUI.DayPanel.DayPanel;

import javax.swing.border.LineBorder;
import java.awt.*;

public class DefaultPanelDecorator extends DayPanelDecorator {

    public DefaultPanelDecorator(DayPanel dayPanel){
        super(dayPanel);
        setColor();
    }

    @Override
    public void setColor(){
        dayPanel.setBackground(new Color(155, 155, 255));
        dayPanel.setBorder(new LineBorder(new Color(100, 100, 225)));
    }

}
