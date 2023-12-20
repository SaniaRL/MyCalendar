package GUI.CalendarFrame;

import GUI.ColorSettings;
import GUI.View.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.time.LocalDate;

//The messiest class of all classes ever
public class CalendarFrame extends JFrame {

    //Panels
    private final JPanel contentPanel;
    private final JPanel northPanel;
    private final JPanel eastPanel;
    private final JPanel westPanel;
    private final JPanel southPanel;

    //Views
    View view;

    //Labels
    JLabel monthLabel;
    JLabel yearLabel;

    //Buttons
    private final JButton nextMonth;
    private final JButton previousMonth;

    //Dates
    LocalDate date;

    //Paths
    private final ImageIcon icon;
    private ColorSettings colorSettings;

    public CalendarFrame(){
        date = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 1);
        colorSettings = new ColorSettings();
        contentPanel = new JPanel(new BorderLayout());
        northPanel = new JPanel();
        eastPanel = new JPanel();
        westPanel = new JPanel();
        southPanel = new JPanel();
        nextMonth = new JButton(">>");
        previousMonth = new JButton("<<");
        icon = new ImageIcon("Icons/month.png");
    }

    public void buildCalendar(){
        setSize(new Dimension(1000, 600));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("MyCalendar");
        setIconImage(icon.getImage());

        setVisible(true);
    }

    public void addPanels(){
        buildNorthPanel();
        buildSouthPanel();
        buildSidePanels();

        add(contentPanel);

        setVisible(true);
    }

    public void setView(View view){
        this.view = view;
        contentPanel.add(view, BorderLayout.CENTER);
    }

    public void buildNorthPanel() {
        //Basic Settings
        northPanel.setLayout(new GridLayout(2, 1));
        northPanel.setOpaque(false);

        //Top Panel
        JPanel topPanel = new JPanel(new GridLayout(1, 3));
        topPanel.setOpaque(false);
        JPanel leftPanel = new JPanel();
        leftPanel.setOpaque(false);
        JPanel middlePanel = new JPanel(new GridLayout(2, 1));
        middlePanel.setOpaque(false);
        JPanel rightPanel = new JPanel();
        rightPanel.setOpaque(false);

        //Add everything in the right order
        northPanel.add(topPanel);
        topPanel.add(leftPanel);
        topPanel.add(middlePanel);
        topPanel.add(rightPanel);

        //Month Label
        Border emptyTopBorder = BorderFactory.createEmptyBorder(10, 0,0,0);
        monthLabel = new JLabel(String.valueOf(date.getMonth()), SwingConstants.CENTER);
        monthLabel.setFont(new Font("Sans Serif", Font.BOLD, 23));
        monthLabel.setPreferredSize(new Dimension(100, 40));
        monthLabel.setOpaque(false);
        monthLabel.setBorder(emptyTopBorder);
        middlePanel.add(monthLabel);

        //Year Label
        Border emptyBottomBorder = BorderFactory.createEmptyBorder(0, 0,20,0);
        yearLabel = new JLabel(String.valueOf(date.getYear()), SwingConstants.CENTER);
        yearLabel.setBorder(emptyBottomBorder);
        yearLabel.setOpaque(false);
        middlePanel.add(yearLabel);

        buildWeekPanel();
        contentPanel.add(northPanel, BorderLayout.NORTH);
    }

    public void buildWeekPanel(){
        JPanel weekDays = new JPanel(new GridLayout(1, 7));
        JPanel weekDayPanel = new JPanel(new BorderLayout());
        weekDayPanel.setOpaque(false);
        weekDays.setOpaque(false);

        DayOfWeek dayOfWeek = DayOfWeek.MONDAY;
        for (int i = 0; i < 7; i++) {
            JLabel label = new JLabel(dayOfWeek.toString().charAt(0) +
                    dayOfWeek.toString().substring(1).toLowerCase(), SwingConstants.CENTER);
            label.setOpaque(false);
            weekDays.add(label);
            dayOfWeek = dayOfWeek.plus(1);
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

        buildNavigationButton(nextMonth, 1);
        eastPanel.add(nextMonth);
        eastPanel.setOpaque(false);
        contentPanel.add(eastPanel, BorderLayout.EAST);

        buildNavigationButton(previousMonth, -1);
        westPanel.add(previousMonth);
        westPanel.setOpaque(false);
        contentPanel.add(westPanel, BorderLayout.WEST);
    }

    public void buildNavigationButton(JButton button, int i){
        button.setPreferredSize(new Dimension(50, this.getHeight() - 300));
        button.setBackground(colorSettings.getEmptyBackgroundColor());
        button.setBorder(new LineBorder(colorSettings.getBorderColor(), 3));

        for(ActionListener actionListener : button.getActionListeners()){
            button.removeActionListener(actionListener);
        }

        button.addActionListener(e -> {
            view.navigate(i);
            view.setDetails();
            date = view.getDate();

            monthLabel.setText(String.valueOf(date.getMonth()));
            yearLabel.setText(String.valueOf(date.getYear()));

        });
    }

    public void buildSouthPanel(){
        southPanel.setOpaque(false);
        JLabel info = new JLabel("Sania Runnfors Larsson");
        southPanel.add(info);
        contentPanel.add(southPanel, BorderLayout.SOUTH);
    }

    public void setColorSettings(ColorSettings colorSettings) {
        this.colorSettings = colorSettings;
        contentPanel.setBackground(colorSettings.getColor());
        nextMonth.setBackground(colorSettings.getEmptyBackgroundColor());
        previousMonth.setBackground(colorSettings.getEmptyBackgroundColor());
    }
}
