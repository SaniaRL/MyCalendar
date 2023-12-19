package GUI.DayPanel.Decorator;

import GUI.DayPanel.DayPanel;

import javax.swing.border.LineBorder;
import java.awt.*;

public class PinkPanelDecorator extends DayPanelDecorator {
    public PinkPanelDecorator(DayPanel dayPanel){
        super(dayPanel, new Color(255, 155, 185), new Color(120, 30, 50));
        setColor();
    }
}
