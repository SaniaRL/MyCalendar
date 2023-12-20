package GUI.DayPanel.Decorator;

import GUI.DayPanel.DayPanel;

import javax.swing.border.LineBorder;
import java.awt.*;

public class DefaultPanelDecorator extends DayPanelDecorator {
    public DefaultPanelDecorator(DayPanel dayPanel){
        super(dayPanel, new Color(155, 155, 255), new Color(100, 100, 225));
        setColor();
    }
}
