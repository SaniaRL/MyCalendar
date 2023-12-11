package GUI.DayPanel.Decorator;

import GUI.ColorSettings;
import GUI.DayPanel.DayPanel;

public abstract class DayPanelDecorator {

    ColorSettings colorSettings;
    DayPanel dayPanel;

    public DayPanelDecorator(ColorSettings colorSettings, DayPanel dayPanel) {
        this.colorSettings = colorSettings;
        this.dayPanel = dayPanel;
    }

    void setColor(){}
}
