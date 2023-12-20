package GUI.DayPanel.Decorator;

import GUI.DayPanel.DayPanel;

import javax.swing.border.LineBorder;
import java.awt.*;

public class GreenPanelDecorator extends DayPanelDecorator {
    public GreenPanelDecorator(DayPanel dayPanel){
        super(dayPanel, new Color(10, 240, 10), new Color(10, 200, 10));
        setColor();
    }
}
