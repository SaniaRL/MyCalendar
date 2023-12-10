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

public class MonthView extends JPanel implements CalenderStrategy {

    ColorSettings colorSettings;
    LocalDate date;
    public MonthView(ColorSettings colorSettings, LocalDate date){
        this.colorSettings = colorSettings;
        this.date = date;

        setLayout(new GridLayout(6, 7));
        setBorder(new LineBorder(colorSettings.getBorderColor(), 2));
        buildDays();
    }

    public void buildDays(){
        removeAll();
        DayPanelFactory dayPanelFactory = new DayPanelFactory();
        DayOfMonth dayOfMonth = new DayOfMonth(date);
        List<LocalDate> localDateList = dayOfMonth.getDateList();
        for(LocalDate localDate : localDateList){
            boolean currentMonth = localDate.getMonth().equals(date.getMonth());
            DayPanel dayPanel = dayPanelFactory.createDayPanel(currentMonth, localDate);
            add(dayPanel);
        }
    }
    public void changeMonthDetails(){
        buildDays();

//        monthLabel.setText(String.valueOf(date.getMonth()));
//        yearLabel.setText(String.valueOf(date.getYear()));
        repaint();
        revalidate();
    }
}
