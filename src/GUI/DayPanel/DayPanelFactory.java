package GUI.DayPanel;

public class DayPanelFactory {
    public DayPanel createDayPanel(DayVariations dayType){
        return switch (dayType){
            case EMPTY -> new EmptyPanel();
            case WEEKDAY -> new WeekDayPanel();
            case WEEKEND -> new WeekendPanel();
        };
    }
}