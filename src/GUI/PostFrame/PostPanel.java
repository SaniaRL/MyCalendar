package GUI.PostFrame;

import GUI.ColorSettings;
import FileManager.FileOperationType;

import java.time.LocalDate;

public class PostPanel extends EntryPanel {
    protected PostPanel(ColorSettings colorSettings, LocalDate date) {
        super(colorSettings, date);
    }

    @Override
    public void fileOperation(FileOperationType fileOperationType) {

    }
}
