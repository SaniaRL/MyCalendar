package GUI.DayPanel;

import GUI.ColorSettings;

import java.time.LocalDate;

public class TodayPanel extends DayPanel{
    protected TodayPanel(LocalDate date, ColorSettings colorSettings) {
        super(date, colorSettings);
        addDetails();
    }

    public void addDetails(){
        setBackground(color.getTodayBackgroundColor());
        dateLabel.setForeground(color.getTodayForegroundColor());
    }
}
