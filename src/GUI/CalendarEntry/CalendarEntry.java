package GUI.CalendarEntry;

import FileManager.FileOperationType;

import java.time.LocalDate;

public abstract class CalendarEntry {

    String path;
    Category category;
    LocalDate date;
    String title;
    String content;

    protected CalendarEntry(Category category, LocalDate date, String title, String content){
        this.category = category;
        this.date = date;
        this.title = title;
        this.content = content;
        path = category.getPath();
    }

    public Category getCategory() {
        return category;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
