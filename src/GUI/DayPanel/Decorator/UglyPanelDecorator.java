package GUI.DayPanel.Decorator;

import GUI.DayPanel.DayPanel;

import javax.swing.border.LineBorder;
import java.awt.*;

public class UglyPanelDecorator extends DayPanelDecorator {
    public UglyPanelDecorator(DayPanel dayPanel){
        super(dayPanel, new Color(255, 155, 185), new Color(187, 130, 57));
        setColor();
    }
}
