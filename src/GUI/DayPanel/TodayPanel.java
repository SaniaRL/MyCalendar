package GUI.DayPanel;

import GUI.ColorSettings;

import java.time.LocalDate;

public class TodayPanel extends DayPanel{
    protected TodayPanel(LocalDate date, ColorSettings colorSettings) {
        super(date, colorSettings);
        addDetails();
    }

    @Override
    public void addDetails(){
        setBackground(color.getTodayBackgroundColor());
        dateLabel.setForeground(color.getTodayForegroundColor());
    }

    @Override
    public void restore(){
        setBorder(border);
        setBackground(color.getTodayBackgroundColor());
        dateLabel.setForeground(color.getTodayForegroundColor());
    }
}
