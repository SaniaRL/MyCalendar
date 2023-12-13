package GUI.DayPanel;

import GUI.ColorSettings;

import java.time.LocalDate;

public class WeekDayPanel extends DayPanel {

    public WeekDayPanel(LocalDate date, ColorSettings colorSettings){
        super(date, colorSettings.getWeekdayBackgroundColor(), colorSettings.getWeekdayForegroundColor(),
                colorSettings.getBorderColor());
        setDetails();
    }
}
