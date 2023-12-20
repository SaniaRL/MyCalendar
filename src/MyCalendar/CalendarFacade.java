package MyCalendar;

import GUI.CalendarFrame.CalendarFrame;
import GUI.CalendarFrame.Menu;
import GUI.ColorSettings;
import GUI.DayPanel.DayPanel;
import GUI.PostFrame.PostFrame;
import GUI.View.*;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

public class CalendarFacade {

    //Frames
    CalendarFrame calendarFrame;
    PostFrame postFrame;

    //Views
    View view;
    MonthView monthView;
    WeekView weekView;
    DayView dayView;

    //Menu
    Menu menu;

    //Misc
    ColorSettings colorSettings;
    LocalDate date;
    DayPanel clickedPanel;


    public CalendarFacade(){
        calendarFrame = new CalendarFrame();
        date = LocalDate.now();
        colorSettings = new ColorSettings();
        monthView = new MonthView(colorSettings, date, this::panelClicked);
        weekView = new WeekView(colorSettings, date);
        dayView = new DayView(colorSettings, date);
        menu = new Menu();
        postFrame = new PostFrame(colorSettings, date);
    }

    public void openCalendar(){
        calendarFrame.buildCalendar();
        calendarFrame.addPanels();
    }

    public void addMenu(){
        calendarFrame.setJMenuBar(menu);
        addActionListenersToMenu();
    }

    public void monthView(){
        view = monthView;
        calendarFrame.setView(view);
        calendarFrame.revalidate();
    }

    public void panelClicked() {
        clickedPanel = monthView.getClickedPanel();
        clickedPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                SwingUtilities.invokeLater(()-> {
                    postFrame.setDate(clickedPanel.getDate());
                    postFrame.buildFrame();
                });
            }
        });
    }

    public void addActionListenersToMenu(){
        menu.getMonth().addActionListener(e -> view = monthView);
        menu.getWeek().addActionListener(e -> view = weekView);
        menu.getDay().addActionListener(e -> view = dayView);

        menu.getGrey().addActionListener(e -> addActionListenersToColorMenu("Grey"));
        menu.getGreen().addActionListener(e -> addActionListenersToColorMenu("Green"));
        menu.getPink().addActionListener(e -> addActionListenersToColorMenu("Pink"));
        menu.getUgly().addActionListener(e -> addActionListenersToColorMenu("Ugly"));
    }

    public void addActionListenersToColorMenu(String color){
        if(color.equalsIgnoreCase("Grey")) colorSettings.setDefaultColorScheme();
        else if(color.equalsIgnoreCase("Green")) colorSettings.setGreenColorScheme();
        else if(color.equalsIgnoreCase("Pink")) colorSettings.setPinkColorScheme();
        else colorSettings.setUglyColorScheme();
        changeColorSettings();
    }

    public void changeColorSettings(){
        calendarFrame.setColorSettings(colorSettings);
        view.setColorSettings(colorSettings);
        calendarFrame.revalidate();
        postFrame.setColorSettings(colorSettings);
        postFrame.repaint();
        postFrame.revalidate();
    }
}
