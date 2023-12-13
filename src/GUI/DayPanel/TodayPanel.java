package GUI.DayPanel;

import GUI.ColorSettings;

import java.time.LocalDate;

public class TodayPanel extends DayPanel{
    protected TodayPanel(LocalDate date, ColorSettings colorSettings) {
        super(date, colorSettings.getTodayBackgroundColor(), colorSettings.getTodayForegroundColor(),
                colorSettings.getBorderColor());
        setDetails();
    }
}
