package GUI.View;

import GUI.ColorSettings;

import javax.swing.*;
import java.time.LocalDate;

public class View extends JPanel implements CalendarStrategy {

    ColorSettings colorSettings;

    public void setColorSettings(ColorSettings colorSettings) {
        this.colorSettings = colorSettings;
    }

    @Override
    public void setDetails() {

    }

    @Override
    public void navigate(int i) {

    }

    @Override
    public LocalDate getDate() {
        return null;
    }

}
