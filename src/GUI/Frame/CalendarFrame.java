package GUI.Frame;

import GUI.ColorSettings;
import GUI.View.DayView;
import GUI.View.MonthView;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.time.LocalDate;
//import java.util.Calendar;

public class CalendarFrame extends JFrame {

    //Panels
    private final JPanel contentPanel;
    private final JPanel northPanel;
    private final JPanel eastPanel;
    private final JPanel westPanel;
    private final JPanel southPanel;
    MonthView monthView;
    DayView dayView;

    //Labels
    JLabel monthLabel;
    JLabel yearLabel;

    //Buttons
    private final JButton nextMonth;
    private final JButton previousMonth;
    private final JButton newPost;
    private final JButton account;

    LocalDate date;

    //Paths
    private final ImageIcon icon;
    private ColorSettings colorSettings;


    //TODO Remove Main
    public static void main(String[] args){
        @SuppressWarnings("unused")
        CalendarFrame calendarFrame = new CalendarFrame();
    }

    public CalendarFrame(){
        colorSettings = new ColorSettings();
        date = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 1);


        colorSettings = new ColorSettings();
        contentPanel = new JPanel();
        northPanel = new JPanel();
        monthView = new MonthView(colorSettings, date);
        dayView = new DayView(colorSettings, date);
        eastPanel = new JPanel();
        westPanel = new JPanel();
        southPanel = new JPanel();

        nextMonth = new JButton(">>");
        previousMonth = new JButton("<<");
        newPost = new JButton();
        account = new JButton();


        icon = new ImageIcon("Icons/calendarIcon.png");
        buildFrame();
    }



    private void buildFrame(){
        setSize(new Dimension(1000, 600));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("MyCalendar");
        setIconImage(icon.getImage());

        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBackground(colorSettings.getColor());
        contentPanel.setOpaque(true);
        contentPanel.setVisible(true);

        buildNorthPanel();
        contentPanel.add(northPanel, BorderLayout.NORTH);
        contentPanel.add(monthView, BorderLayout.CENTER);
//        contentPanel.add(dayView, BorderLayout.CENTER);

        buildSidePanels();
        buildSouthPanel();

        add(contentPanel);
        setVisible(true);
    }

    public void buildNorthPanel() {
        //Weekdays, Month or Year info.
        northPanel.setLayout(new GridLayout(2, 1));
        northPanel.setOpaque(false);

        JPanel topPanel = new JPanel(new GridLayout(1, 3));
        topPanel.setOpaque(false);
        JPanel leftPanel = new JPanel();
        leftPanel.setOpaque(false);
        JPanel middlePanel = new JPanel(new GridLayout(2, 1));
        middlePanel.setOpaque(false);
        JPanel rightPanel = new JPanel();
        rightPanel.setOpaque(false);

        northPanel.add(topPanel);
        topPanel.add(leftPanel);
        topPanel.add(middlePanel);
        topPanel.add(rightPanel);


        buildNorthPanelButtons(newPost, new ImageIcon("Icons/new.png"));
        buildNorthPanelButtons(account, new ImageIcon("Icons/account.png"));

//        leftPanel.add(newPost);
//        rightPanel.add(account);

        Border emptyTopBorder = BorderFactory.createEmptyBorder(10, 0,0,0);
        monthLabel = new JLabel(String.valueOf(date.getMonth()), SwingConstants.CENTER);
        monthLabel.setFont(new Font("Sans Serif", Font.BOLD, 23));
        monthLabel.setPreferredSize(new Dimension(100, 40));
        monthLabel.setOpaque(false);
        monthLabel.setBorder(emptyTopBorder);
        middlePanel.add(monthLabel);


        Border emptyBottomBorder = BorderFactory.createEmptyBorder(0, 0,20,0);
        yearLabel = new JLabel(String.valueOf(date.getYear()), SwingConstants.CENTER);
        yearLabel.setBorder(emptyBottomBorder);
        yearLabel.setOpaque(false);
        middlePanel.add(yearLabel);

        buildWeekPanel();
    }

    public void buildNorthPanelButtons(JButton button, ImageIcon imageIcon){
        button.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
        button.setBackground(colorSettings.getBorderColor());
        button.setPreferredSize(new Dimension(40,40));
    }

    public void buildWeekPanel(){
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

        monthView.setDate(date);
        monthView.changeDetails();
        repaint();
        revalidate();

        monthLabel.setText(String.valueOf(date.getMonth()));
        yearLabel.setText(String.valueOf(date.getYear()));
        repaint();
        revalidate();
    }
}
