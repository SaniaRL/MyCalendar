package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Calendar;

public class CalendarFrame extends JFrame {

    //Panels
    private final JPanel northPanel;
    private final JPanel centerPanel;

    //Paths
    private final ImageIcon icon;

    private int currentMonth;
    private int currentYear;

    //TODO Remove Main
    public static void main(String[] args){
        CalendarFrame calendarFrame = new CalendarFrame();
    }

    public CalendarFrame(){
        northPanel = new JPanel();
        centerPanel = new JPanel();
        icon = new ImageIcon("Icons/calendarIcon.png");
        buildFrame();

        currentMonth = Calendar.getInstance().get(Calendar.MONTH);
        currentYear = Calendar.getInstance().get(Calendar.YEAR);
    }

    private void buildFrame(){
        setSize(new Dimension(1400, 800));
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("MyCalendar");
        setIconImage(icon.getImage());
        setVisible(true);

        buildNorthPanel();
        add(northPanel, BorderLayout.NORTH);

        buildCenterPanel();
        add(centerPanel, BorderLayout.CENTER);
    }

    public void buildNorthPanel(){
        northPanel.setLayout(new GridLayout(2, 1));
        JLabel monthLabel = new JLabel(String.valueOf(currentMonth), SwingConstants.CENTER);
        JLabel yearLabel = new JLabel(String.valueOf(currentYear), SwingConstants.CENTER);
        northPanel.add(yearLabel, SwingConstants.CENTER);
        northPanel.add(monthLabel, SwingConstants.CENTER);
    }

    public void buildCenterPanel(){
        centerPanel.setLayout(new GridLayout(5, 7));
        centerPanel.setBorder(new LineBorder(Color.BLACK, 4));
        buildDays(centerPanel, 35);
    }

    public void buildDays(JPanel monthPanel, int amount){
        for(int i = 0; i < amount; i++){
            JPanel dayPanel = new JPanel();
            dayPanel.setBorder(new LineBorder(Color.BLACK, 1));
            monthPanel.add(dayPanel);
        }
    }
}
