package MyCalendar;

import GUI.CalendarFrame.CalendarFrame;
import GUI.CalendarFrame.Menu;
import GUI.ColorSettings;
import GUI.View.*;

import java.time.LocalDate;

public class CalendarFacade {

    CalendarFrame calendarFrame;

    View view;
    MonthView monthView;
    WeekView weekView;
    DayView dayView;

    Menu menu;

    ColorSettings colorSettings;
    LocalDate date;

    public CalendarFacade(){
        calendarFrame = new CalendarFrame();
        date = LocalDate.now();
        colorSettings = new ColorSettings();
        monthView = new MonthView(colorSettings, date, calendarFrame::panelClicked);
        weekView = new WeekView(colorSettings, date);
        dayView = new DayView(colorSettings, date);
        menu = new Menu();
    }

    public void openCalendar(){
        calendarFrame.buildCalendar();
    }

    public void addMenu(){
        calendarFrame.setJMenuBar(menu);
    }

    public void addActionListenersToMenu(){
        //GUI.View Menu
        menu.getMonth().addActionListener(e -> {
            view = monthView;
//            updateGUI();
        });

        menu.getWeek().addActionListener(e -> {
            view = weekView;
//            updateGUI();
        });

        menu.getDay().addActionListener(e -> {
            view = dayView;
//            updateGUI();
        });

        //Color Menu
        menu.getGrey().addActionListener(e -> {
            colorSettings.setDefaultColorScheme();
//            updateGUI();
        });
        menu.getGreen().addActionListener(e -> {
            colorSettings.setGreenColorScheme();
//            updateGUI();
        });
        menu.getPink().addActionListener(e -> {
            colorSettings.setPinkColorScheme();
//            updateGUI();
        });
        menu.getUgly().addActionListener(e -> {
            colorSettings.setUglyColorScheme();
            calendarFrame.
//            updateGUI();
        });
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
