package GUI.CalendarEntry;

import FileManager.FileOperation;
import FileManager.FileOperationType;

import java.time.LocalDate;

public class Post extends CalendarEntry implements FileOperation {
    public Post(Category category, LocalDate date, String content){
        super(category, date, content);
    }

    @Override
    public void fileOperations(FileOperationType fileOperationType) {

    }
}