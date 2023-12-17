package GUI.CalendarEntry;

import FileManager.FileOperationType;

import java.awt.*;
import java.time.LocalDate;

public class Diary extends CalendarEntry {

    public Diary(LocalDate date, String content) {
        super(new Category("Diary", "Persistence/Diary.txt", new Color(170, 50, 250)),
                date, content);
    }

    @Override
    public void fileOperations(FileOperationType fileOperationType) {

    }
}
