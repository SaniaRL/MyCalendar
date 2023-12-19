package MyCalendar;

import GUI.CalendarFrame.CalendarFrame;
import GUI.ColorSettings;
import GUI.View.CalendarStrategy;
import GUI.View.DayView;
import GUI.View.MonthView;
import GUI.View.WeekView;

import java.time.LocalDate;

public class CalendarFacade {

    CalendarFrame calendarFrame;

    CalendarStrategy calendarStrategy;
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
        calendarStrategy = monthView;
        calendarFrame.buildCalendar();
//        calendarFrame.updateGUI();
//        calendarFrame.setView(calendarStrategy);
    }

    public void monthView(){
    }

    public void navigate(){

    }

    public void changeColorSettings(){

    }
}
