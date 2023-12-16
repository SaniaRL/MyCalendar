package GUI.PostFrame;

import GUI.ColorSettings;
import GUI.FileOperation;
import GUI.FileOperationType;

import java.time.LocalDate;

public class PostPanel extends EntryPanel {
    protected PostPanel(ColorSettings colorSettings, LocalDate date) {
        super(colorSettings, date);
    }

    @Override
    public void fileOperation(FileOperationType fileOperationType) {

    }
}
