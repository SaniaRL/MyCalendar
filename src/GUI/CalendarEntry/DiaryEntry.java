package GUI.CalendarEntry;

import FileManager.FileOperationType;

import java.awt.*;
import java.time.LocalDate;

public class DiaryEntry extends CalendarEntry {
    public DiaryEntry(LocalDate date, String title, String content) {
        super(new Category("Diary", "Persistence/Diary.txt", new Color(170, 50, 250)),
                date, title, content);
    }
}
