package GUI.DayPanel;

import GUI.ColorSettings;

import java.time.LocalDate;

public class WeekDayPanel extends DayPanel {

    public WeekDayPanel(LocalDate date, ColorSettings colorSettings){
        super(date, colorSettings);
        addDetails();
    }

    @Override
    public void addDetails(){
        setBackground(color.getWeekdayBackgroundColor());
        dateLabel.setForeground(color.getWeekdayForegroundColor());
    }

    @Override
    public void restore(){
        setBorder(border);
        setBackground(color.getWeekdayBackgroundColor());
        dateLabel.setForeground(color.getWeekdayForegroundColor());
    }
}
