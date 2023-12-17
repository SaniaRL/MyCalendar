package GUI.View;

import GUI.ColorSettings;
import GUI.DayOfMonth;
import GUI.DayPanel.DayPanel;
import GUI.DayPanel.DayPanelFactory;
import GUI.DayPanel.Decorator.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MonthView extends JPanel implements CalendarStrategy, MonthViewParent {

    ColorSettings colorSettings;
    LocalDate date;
    MonthViewParent monthViewParent;
    List<DayPanel> dayPanelList;
    DayPanel clickedPanel;
    DayPanelDecorator dayPanelDecorator;

    public MonthView(ColorSettings colorSettings, LocalDate date, MonthViewParent monthViewParent){
        this.colorSettings = colorSettings;
        this.date = date;
        this.monthViewParent = monthViewParent;
        dayPanelList = new ArrayList<>();

        setLayout(new GridLayout(6, 7));
        setBorder(new LineBorder(colorSettings.getBorderColor(), 2));
        createView();
        addActionListersToDays();
    }

    public void createView(){
        removeAll();
        if(!dayPanelList.isEmpty()){
            dayPanelList.clear();
        }
        DayPanelFactory dayPanelFactory = new DayPanelFactory();
        DayOfMonth dayOfMonth = new DayOfMonth(date);
        List<LocalDate> localDateList = dayOfMonth.getDateList();
        for(LocalDate localDate : localDateList){
            boolean currentMonth = localDate.getMonth().equals(date.getMonth());
            DayPanel dayPanel = dayPanelFactory.createDayPanel(currentMonth, localDate, colorSettings);
            add(dayPanel);
            dayPanelList.add(dayPanel);
        }
    }

    public void setDetails(){
        createView();
        addActionListersToDays();
        repaint();
        revalidate();
    }

    @Override
    public void navigate(int i) {
        date = date.plusMonths(i);
    }

    @Override
    public void panelClicked() {
        monthViewParent.panelClicked();
    }

    public void addActionListersToDays(){
        for(DayPanel dayPanel : dayPanelList){
            dayPanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);
                    System.out.println(dayPanel.getDate());
                    clickedPanel = dayPanel;
                    panelClicked();
                    updateClickedDay();
                }
            });
        }
    }

    public void updateClickedDay(){
        resetDayPanels();
        switch (colorSettings.getColorScheme()){
            case "Grey" -> dayPanelDecorator = new DefaultPanelDecorator(clickedPanel);
            case "Green" -> dayPanelDecorator = new GreenPanelDecorator(clickedPanel);
            case "Pink" -> dayPanelDecorator = new PinkPanelDecorator(clickedPanel);
            case "Ugly" -> dayPanelDecorator = new UglyPanelDecorator(clickedPanel);
        }
        clickedPanel.repaint();
        clickedPanel.revalidate();
    }

    public void resetDayPanels(){
        for(DayPanel dayPanel : dayPanelList){
            dayPanel.setDetails();
        }
    }

    public void setColorSettings(ColorSettings colorSettings) {
        this.colorSettings = colorSettings;
        createView();
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public DayPanel getClickedPanel() {
        return clickedPanel;
    }

    @Override
    public LocalDate getDate() {
        return date;
    }
}
