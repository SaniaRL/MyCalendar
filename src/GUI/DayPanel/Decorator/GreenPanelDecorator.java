package GUI.DayPanel.Decorator;

import GUI.ColorSettings;
import GUI.DayPanel.DayPanel;

import javax.swing.border.LineBorder;
import java.awt.*;

public class GreenPanelDecorator extends DefaultPanelDecorator {

    public GreenPanelDecorator(DayPanel dayPanel){
        super(dayPanel);
        setColor();
    }

    @Override
    public void setColor(){
        dayPanel.setBackground(new Color(80, 255, 80));
        dayPanel.setBorder(new LineBorder(new Color(10, 200, 10)));
    }
}
