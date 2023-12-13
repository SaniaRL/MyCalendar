package GUI.CalendarEntry;

import java.time.LocalDate;

public abstract class CalendarEntry {

    Category category;
    LocalDate date;
    String content;

    protected CalendarEntry(Category category, LocalDate date, String content){

    }
}
