package GUI.DayPanel;

import GUI.ColorSettings;

import java.time.LocalDate;

public class WeekendPanel extends DayPanel {

    public WeekendPanel(LocalDate date, ColorSettings colorSettings){
        super(date, colorSettings);
        addDetails();
    }

    public void addDetails(){
        setBackground(color.getWeekendBackgroundColor());
        dateLabel.setForeground(color.getWeekendForegroundColor());
    }
}
