import GUI.DayPanel.DayPanel;
import GUI.DayPanel.DayPanelFactory;
import GUI.DayPanel.DayVariations;

public class Main {
    public static void main(String[] args){
        DayPanelFactory dayPanelFactory = new DayPanelFactory();
        DayPanel dayPanel = dayPanelFactory.createDayPanel(DayVariations.EMPTY);
    }
}
