package GUI.DayPanel;

import GUI.ColorSettings;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.time.LocalDate;

public class WeekDayPanel extends DayPanel {

    public WeekDayPanel(LocalDate date, ColorSettings colorSettings){
        super(date, colorSettings);
        addDetails();
    }

    public void addDetails(){
        setBackground(color.getWeekdayBackgroundColor());
        dateLabel.setForeground(color.getWeekdayForegroundColor());
    }
}
