package MyCalendar;

import GUI.CalendarFrame.CalendarFrame;
import GUI.ColorSettings;
import GUI.View.*;

import java.time.LocalDate;

public class CalendarFacade {

    CalendarFrame calendarFrame;

    View view;
    MonthView monthView;
    WeekView weekView;
    DayView dayView;

    ColorSettings colorSettings;
    LocalDate date;

    public CalendarFacade(){
        calendarFrame = new CalendarFrame();
        date = LocalDate.now();
        colorSettings = new ColorSettings();
        monthView = new MonthView(colorSettings, date, calendarFrame::panelClicked);
        weekView = new WeekView(colorSettings, date);
        dayView = new DayView(colorSettings, date);
    }

    public void openCalendar(){
        calendarFrame.buildCalendar();
    }

    public void monthView(){
        view = monthView;
        calendarFrame.setView(view);
    }

    public void navigate(){

    }

    public void changeColorSettings(){

    }
}
