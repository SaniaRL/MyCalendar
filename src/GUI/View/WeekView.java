package GUI.View;

import GUI.ColorSettings;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class WeekView extends View {

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

    public void createView() {
        setLayout(new BorderLayout());
    }

    @Override
    public void setDetails() {

    }

    @Override
    public void navigate(int i) {
        date = date.plusDays(i * 7L);
    }

    @Override
    public LocalDate getDate() {
        return date;
    }

    public void setColorSettings(ColorSettings colorSettings) {
        this.colorSettings = colorSettings;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
