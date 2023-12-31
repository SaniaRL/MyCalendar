package GUI.PostFrame;

import GUI.ColorSettings;
import FileManager.FileOperation;
import FileManager.FileOperationType;

import javax.swing.*;
import java.time.LocalDate;

public abstract class EntryPanel extends JPanel implements FileOperation {

    protected ColorSettings colorSettings;
    protected LocalDate date;


    protected EntryPanel(ColorSettings colorSettings, LocalDate date){
        this.colorSettings = colorSettings;
        this.date = date;
    }
    @Override
    public void fileOperations(FileOperationType fileOperationType) {

    }

    public abstract void fileOperation(FileOperationType fileOperationType);
}
