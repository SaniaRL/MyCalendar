package GUI.DayPanel;

import java.time.LocalDate;

public class TodayPanel extends DayPanel{
    protected TodayPanel(LocalDate date) {
        super(date);
        addDetails();
    }

    public void addDetails(){
        setBackground(color.getTodayBackgroundColor());
        dateLabel.setForeground(color.getTodayForegroundColor());
    }
}
