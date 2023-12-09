package GUI.DayPanel;

import java.awt.*;
import java.time.LocalDate;

public class WeekendPanel extends DayPanel {

    public WeekendPanel(LocalDate date){
        super(date);
        addDetails();
    }

    public void addDetails(){
        setBackground(color.getWeekendBackgroundColor());
        dateLabel.setForeground(color.getWeekendForegroundColor());
    }

}
