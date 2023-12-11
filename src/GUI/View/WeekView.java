package GUI.View;

import GUI.ColorSettings;

import javax.swing.*;
import java.time.LocalDate;

public class WeekView extends JPanel implements CalendarStrategy {

    ColorSettings colorSettings;
    LocalDate date;

    JPanel northPanel;
    JPanel centerPanel;
    JPanel southPanel;

    JLabel weekPanel;

    public WeekView(ColorSettings colorSettings, LocalDate date){
        this.colorSettings = colorSettings;
        this.date = date;

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();

        weekPanel = new JLabel("Week");

        createView();
    }

    @Override
    public void createView() {

    }

    @Override
    public void changeDetails() {

    }

    public void setColorSettings(ColorSettings colorSettings) {
        this.colorSettings = colorSettings;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
