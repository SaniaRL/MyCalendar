package GUI.DayPanel.Decorator;

import GUI.ColorSettings;
import GUI.DayPanel.DayPanel;

public abstract class DayPanelDecorator {

    DayPanel dayPanel;

    public DayPanelDecorator( DayPanel dayPanel) {
        this.dayPanel = dayPanel;
    }

    void setColor(){
        System.out.println("Set Color");
    }
}