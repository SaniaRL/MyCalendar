package GUI.CalendarEntry;

import FileManager.FileOperationType;

import java.time.LocalDate;

public abstract class CalendarEntry {

    Category category;
    LocalDate date;
    String content;

    protected CalendarEntry(Category category, LocalDate date, String content){

    }

    public abstract void fileOperations(FileOperationType fileOperationType);
}
