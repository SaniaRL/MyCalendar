package GUI.CalendarEntry;

import FileManager.FileOperation;
import FileManager.FileOperationType;

import java.awt.*;
import java.time.LocalDate;

public class Post extends CalendarEntry implements FileOperation {
    public Post(LocalDate date, String title, String content){
        super(new Category("Diary", "Persistence/Diary.txt", new Color(40, 120, 70)),
                date, title, content);
    }
}