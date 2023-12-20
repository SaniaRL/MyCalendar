package GUI.PostFrame;

import GUI.CalendarEntry.CalendarEntry;
import GUI.ColorSettings;

import javax.swing.*;
import java.awt.*;

public class EntryButton extends JButton {

    public void buildMonthButton(CalendarEntry calendarEntry){
        setText(calendarEntry.getTitle());
        setBackground(calendarEntry.getCategory().getColor());
    }
    public void buildDayButton(CalendarEntry calendarEntry){
        setText(calendarEntry.getTitle());
        setBackground(calendarEntry.getCategory().getColor());
    }
}
