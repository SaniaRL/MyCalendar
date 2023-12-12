package GUI.DayPanel;

import GUI.ColorSettings;
import GUI.DayOfMonth;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.time.LocalDate;

public abstract class DayPanel extends JPanel implements BuildRestore {

    protected LocalDate date;
    protected JLabel dateLabel;
    protected DayOfMonth dayOfMonth;
    protected ColorSettings color;
    protected Border border;

    protected DayPanel(LocalDate date, ColorSettings colorSettings){
        this.date = date;
        dateLabel = new JLabel(" " + date.getDayOfMonth());
        dayOfMonth = new DayOfMonth(date);
        color = colorSettings;
        border = new LineBorder(color.getBorderColor());
        buildPanel();
    }

    protected void buildPanel(){
        setOpaque(true);
        setLayout(new GridLayout(5, 1));
        setBorder(border);

        setDateLabel();

        setVisible(true);
    }

    protected void setDateLabel(){
        JPanel topPanel = new JPanel(new GridLayout(1, 2));
        topPanel.add(dateLabel);
        topPanel.setOpaque(false);
        dateLabel.setOpaque(false);
        add(topPanel);
    }

    public LocalDate getDate() {
        return date;
    }

}
