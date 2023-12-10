package GUI.Frame;

import GUI.ColorSettings;
import GUI.DayOfMonth;
import GUI.DayPanel.DayPanel;
import GUI.DayPanel.DayPanelFactory;
import GUI.View.MonthView;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

public class CalendarFrame extends JFrame {

    //Panels
    private final JPanel contentPanel;
    private final JPanel northPanel;
//    private final JPanel centerPanel;
    private final JPanel eastPanel;
    private final JPanel westPanel;
<<<<<<< HEAD
    MonthView monthView;
=======
    private final JPanel southPanel;
>>>>>>> ColorSettings

    //Labels
    JLabel monthLabel;
    JLabel yearLabel;

    //Buttons
    private final JButton nextMonth;
    private final JButton previousMonth;

    LocalDate date;

    //Paths
    private final ImageIcon icon;
    private ColorSettings colorSettings;

    private int currentMonth;
    private int currentYear;

    //TODO Remove Main
    public static void main(String[] args){
        CalendarFrame calendarFrame = new CalendarFrame();
    }

    public CalendarFrame(){
<<<<<<< HEAD
        colorSettings = new ColorSettings();
        date = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 1);

=======

        colorSettings = new ColorSettings();
        contentPanel = new JPanel();
>>>>>>> ColorSettings
        northPanel = new JPanel();
//        centerPanel = new JPanel();
        monthView = new MonthView(colorSettings, date);
        eastPanel = new JPanel();
        westPanel = new JPanel();
        southPanel = new JPanel();

        nextMonth = new JButton(">>");
        previousMonth = new JButton("<<");


        icon = new ImageIcon("Icons/calendarIcon.png");
        buildFrame();

        currentMonth = Calendar.getInstance().get(Calendar.MONTH);
        currentYear = Calendar.getInstance().get(Calendar.YEAR);
    }



    private void buildFrame(){
        setSize(new Dimension(1000, 600));
//        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("MyCalendar");
        setIconImage(icon.getImage());

        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBackground(colorSettings.getColor());
        contentPanel.setOpaque(true);
        contentPanel.setVisible(true);

        buildNorthPanel();
<<<<<<< HEAD
        add(northPanel, BorderLayout.NORTH);

//        buildCenterPanel();
        add(monthView, BorderLayout.CENTER);
//        add(centerPanel, BorderLayout.CENTER);

=======
        buildCenterPanel();
>>>>>>> ColorSettings
        buildSidePanels();
        buildSouthPanel();

        add(contentPanel);
        setVisible(true);
    }

    public void buildNorthPanel() {
        //Weekdays, Month or Year info.
        northPanel.setLayout(new GridLayout(3, 1));
        northPanel.setOpaque(false);

        Border emptyTopBorder = BorderFactory.createEmptyBorder(10, 0,0,0);
        monthLabel = new JLabel(String.valueOf(date.getMonth()), SwingConstants.CENTER);
        monthLabel.setFont(new Font("Sans Serif", Font.BOLD, 23));
        monthLabel.setPreferredSize(new Dimension(100, 40));
        monthLabel.setBorder(emptyTopBorder);
        northPanel.add(monthLabel);


        Border emptyBottomBorder = BorderFactory.createEmptyBorder(0, 0,20,0);
        yearLabel = new JLabel(String.valueOf(date.getYear()), SwingConstants.CENTER);
        yearLabel.setBorder(emptyBottomBorder);
        northPanel.add(yearLabel);

        JPanel weekDayPanel = new JPanel(new BorderLayout());
        weekDayPanel.setOpaque(false);
        JPanel weekDays = new JPanel(new GridLayout(1, 7));
        weekDays.setOpaque(false);
        String[] weekDayNames = {
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday",
        };

        for (String weekDayName : weekDayNames) {
            JLabel label = new JLabel(weekDayName, SwingConstants.CENTER);
            label.setOpaque(false);
            weekDays.add(label);
//            label.setBorder(new LineBorder(Color.BLACK, 2));
        }
        //Create empty Panels the width of the next and previous buttons - svenska eller engelska IDK
        JPanel emptyPanel = new JPanel();
        emptyPanel.setPreferredSize(new Dimension(60, 1));
        emptyPanel.setOpaque(false);

        JPanel emptyPanel2 = new JPanel();
        emptyPanel2.setPreferredSize(new Dimension(60, 1));
        emptyPanel2.setOpaque(false);

        weekDayPanel.add(emptyPanel, BorderLayout.WEST);
        weekDayPanel.add(emptyPanel2, BorderLayout.EAST);
        weekDayPanel.add(weekDays, BorderLayout.CENTER);
        northPanel.add(weekDayPanel);
        contentPanel.add(northPanel, BorderLayout.NORTH);
    }

    /*
    public void buildCenterPanel(){
        centerPanel.setLayout(new GridLayout(6, 7));
        centerPanel.setBorder(new LineBorder(colorSettings.getBorderColor(), 2));
        buildDays();
        contentPanel.add(centerPanel, BorderLayout.CENTER);
    }



    public void buildDays(){
        centerPanel.removeAll();
        DayPanelFactory dayPanelFactory = new DayPanelFactory();
        DayOfMonth dayOfMonth = new DayOfMonth(date);
        List<LocalDate> localDateList = dayOfMonth.getDateList();
        for(LocalDate localDate : localDateList){
            boolean currentMonth = localDate.getMonth().equals(date.getMonth());
            DayPanel dayPanel = dayPanelFactory.createDayPanel(currentMonth, localDate);
            centerPanel.add(dayPanel);
        }
    }

     */

    public void buildSidePanels(){

        buildChangeMonthButton(nextMonth, 1);
        eastPanel.add(nextMonth);
        eastPanel.setOpaque(false);
        contentPanel.add(eastPanel, BorderLayout.EAST);

        buildChangeMonthButton(previousMonth, -1);
        westPanel.add(previousMonth);
        westPanel.setOpaque(false);
        contentPanel.add(westPanel, BorderLayout.WEST);
    }

    public void buildChangeMonthButton(JButton button, int i){
        button.setPreferredSize(new Dimension(50, this.getHeight() - 300));
        button.setBackground(colorSettings.getEmptyBackgroundColor());
        button.setBorder(new LineBorder(colorSettings.getBorderColor(), 3));

        button.addActionListener(e -> {
            date = date.plusMonths(i);
            changeMonthDetails();
        });


    }

    public void buildSouthPanel(){
        southPanel.setOpaque(false);
        JLabel info = new JLabel(" Sania Runnfors Larsson");
        southPanel.add(info);
        contentPanel.add(southPanel, BorderLayout.SOUTH);
    }

    public void changeMonthDetails(){
//        buildDays();



        monthLabel.setText(String.valueOf(date.getMonth()));
        yearLabel.setText(String.valueOf(date.getYear()));
        repaint();
        revalidate();
    }
}
