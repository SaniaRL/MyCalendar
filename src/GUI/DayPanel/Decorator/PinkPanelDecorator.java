package GUI.DayPanel.Decorator;

import GUI.ColorSettings;
import GUI.DayPanel.DayPanel;

import javax.swing.border.LineBorder;
import java.awt.*;

public class PinkPanelDecorator extends DayPanelDecorator {

    public PinkPanelDecorator(ColorSettings colorSettings, DayPanel dayPanel){
        super(colorSettings, dayPanel);
    }

    @Override
    public void setColor(){
        dayPanel.setBackground(new Color(255, 155, 185));
        dayPanel.setBorder(new LineBorder(new Color(120, 30, 50)));
    }

}
