package MyCalendar;

import GUI.CalendarFrame.CalendarFrame;

public class CalendarFacade {

    CalendarFrame calendarFrame;

    public CalendarFacade(){
        calendarFrame = new CalendarFrame();
    }

    public void openCalendar(){
        calendarFrame.buildFrame();
        calendarFrame.updateGUI();
    }

    public void navigate(){

    }

    public void changeColorSettings(){
        
    }
}
