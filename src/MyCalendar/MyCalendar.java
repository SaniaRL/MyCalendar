package MyCalendar;

public class MyCalendar {

    public static void main(String[] args){
        //CalendarFacade
        CalendarFacade calendarFacade = new CalendarFacade();
        //Open Frame
        calendarFacade.openCalendar();
        //Set Month View
        calendarFacade.monthView();
        //Add Menu To Frame
        calendarFacade.addMenu();
    }
}
