package GUI.DayPanel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.time.LocalDate;

public class WeekDayPanel extends DayPanel {

    public WeekDayPanel(LocalDate date){
        super(date);
        addDetails();
    }

    public void addDetails(){
        setBackground(color.getWeekdayBackgroundColor());
        dateLabel.setForeground(color.getWeekdayForegroundColor());
    }
}
