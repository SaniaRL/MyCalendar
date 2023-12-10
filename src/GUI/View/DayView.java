package GUI.View;

import GUI.ColorSettings;
import GUI.DayOfMonth;
import GUI.DayPanel.DayPanel;
import GUI.DayPanel.DayPanelFactory;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.time.LocalDate;
import java.util.List;

public class DayView extends JPanel implements CalendarStrategy {

    ColorSettings colorSettings;
    LocalDate date;

    JPanel northPanel;
    JPanel centerPanel;
    JPanel southPanel;

    public DayView(ColorSettings colorSettings, LocalDate date){
        this.colorSettings = colorSettings;
        this.date = date;

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();

        buildDay();
    }
    @Override
    public void createView() {

    }

    @Override
    public void changeDetails() {

    }

    public void buildDay(){
        setLayout(new BorderLayout());
        setBackground(colorSettings.getWeekendBackgroundColor());

        buildNorthPanel();
        buildCenterPanel();
        buildSouthPanel();
    }

    public void buildNorthPanel(){
        northPanel.setLayout(new GridLayout(3, 1));
        JLabel dayPanel = new JLabel(String.valueOf(date.getDayOfWeek()), SwingConstants.CENTER);
        dayPanel.setFont(new Font("Sans Serif", Font.BOLD, 24));
//        northPanel.setOpaque(false);
        northPanel.add(dayPanel);
        add(northPanel, BorderLayout.NORTH);

    }
    public void buildCenterPanel(){
        centerPanel.setLayout(new GridLayout(14,1));
        for(int i = 0; i < 8; i++){
            JLabel label = new JLabel(String.valueOf(i), SwingConstants.CENTER);
            label.setBorder(new LineBorder(colorSettings.getBorderColor(), 2));
            centerPanel.add(label);
            add(centerPanel, BorderLayout.CENTER);
        }

    }
    public void buildSouthPanel(){

    }

}
