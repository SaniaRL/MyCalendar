package GUI.CalendarFrame;

import GUI.ColorSettings;
import GUI.DayPanel.DayPanel;
import GUI.PostFrame.PostFrame;
import GUI.View.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

public class CalendarFrame extends JFrame {

    //Frames
    PostFrame postFrame;

    //Panels
    private final JPanel contentPanel;
    private final JPanel northPanel;
    private final JPanel eastPanel;
    private final JPanel westPanel;
    private final JPanel southPanel;
    DayPanel clickedPanel;

    //Views
    CalendarStrategy view;
    MonthView monthView;
    WeekView weekView;
    DayView dayView;

    //Labels
    JLabel monthLabel;
    JLabel yearLabel;

    //Buttons
    private final JButton nextMonth;
    private final JButton previousMonth;
    private final JButton newPost;
    private final JButton account;

    //Dates
    LocalDate date;

    //Menus
    Menu menu;

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
        menu = new Menu();
        postFrame = new PostFrame(colorSettings, date);
        colorSettings = new ColorSettings();
        contentPanel = new JPanel();
        northPanel = new JPanel();
        //I want to use method Update GUI here it there is a call back
        monthView = new MonthView(colorSettings, date, this::panelClicked);
        weekView = new WeekView(colorSettings, date);
        dayView = new DayView(colorSettings, date);
        eastPanel = new JPanel();
        westPanel = new JPanel();
        southPanel = new JPanel();
        nextMonth = new JButton(">>");
        previousMonth = new JButton("<<");
        newPost = new JButton();
        account = new JButton();
        icon = new ImageIcon("Icons/month.png");
        view = monthView;

        //Action Listeners

        buildFrame();
        buildSidePanels();
        setJMenuBar(menu);
        addActionListenersToMenu();
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

        //Build panels
        buildNorthPanel();
        contentPanel.add(northPanel, BorderLayout.NORTH);
        buildSouthPanel();

        //Add views
        if(view == monthView){
            contentPanel.add(monthView, BorderLayout.CENTER);
        }
        else if(view == weekView){
            contentPanel.add(weekView, BorderLayout.CENTER);
        }
        else if(view == dayView){
            contentPanel.add(dayView, BorderLayout.CENTER);
        }

        //Add menu & Set action Listener to menu

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

        //TODO Decide on buttons existens
        //Build buttons for new post and account and add
        buildNorthPanelButtons(newPost, "+");
        buildNorthPanelButtons(account,"Icons/account.png");

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

    public void buildNorthPanelButtons(JButton button, String text){
        button.setText(text);
//        button.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
        button.setBackground(colorSettings.getBorderColor());
        button.setPreferredSize(new Dimension(50,50));
    }

    public void buildWeekPanel(){
        JPanel weekDays = new JPanel(new GridLayout(1, 7));
        JPanel weekDayPanel = new JPanel(new BorderLayout());
        weekDayPanel.setOpaque(false);
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

          /*  if(view == monthView){
                date = date.plusMonths(i);
            }
            else if(view == dayView){
                date = date.plusDays(i);
            }
            else if(view == weekView){
                date = date.plusDays(i * 7L);
            }

           */
//            changeDetails();
        });
    }

    public void buildSouthPanel(){
        southPanel.setOpaque(false);
        JLabel info = new JLabel(" Sania Runnfors Larsson");
        southPanel.add(info);
        contentPanel.add(southPanel, BorderLayout.SOUTH);
    }

    public void addActionListenersToMenu(){
        //View Menu
        menu.month.addActionListener(e -> {
            view = monthView;
            updateGUI();
        });

        menu.week.addActionListener(e -> {
            view = weekView;
            updateGUI();
        });

        menu.day.addActionListener(e -> {
            view = dayView;
            updateGUI();
        });

        //Color Menu
        menu.grey.addActionListener(e -> {
            colorSettings.setDefaultColorScheme();
            updateGUI();
        });
        menu.green.addActionListener(e -> {
            colorSettings.setGreenColorScheme();
            updateGUI();
        });
        menu.pink.addActionListener(e -> {
            colorSettings.setPinkColorScheme();
            updateGUI();
        });
        menu.ugly.addActionListener(e -> {
            colorSettings.setUglyColorScheme();
            updateGUI();
        });
    }

    public void updateGUI(){
        if(view == monthView){
            contentPanel.remove(dayView);
            contentPanel.remove(weekView);
            monthView.setColorSettings(colorSettings);
        }
        if(view == weekView){
            contentPanel.remove(monthView);
            contentPanel.remove(weekView);
            weekView.setColorSettings(colorSettings);
            contentPanel.add(weekView, BorderLayout.CENTER);
        }
        if(view == dayView){
            contentPanel.remove(monthView);
            contentPanel.remove(weekView);
            dayView.setColorSettings(colorSettings);
            contentPanel.add(dayView, BorderLayout.CENTER);
        }
        System.out.println("UpdateGUI");
        contentPanel.removeAll();
        northPanel.removeAll();
        southPanel.removeAll();
        buildFrame();
        buildSidePanels();
        setJMenuBar(menu);
        addActionListenersToMenu();
        repaint();
        revalidate();
    }

    public void panelClicked() {
        clickedPanel = monthView.getClickedPanel();
        clickedPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                SwingUtilities.invokeLater(()-> {
                    postFrame.setDate(clickedPanel.getDate());
                    postFrame.buildFrame();
                });
            }
        });
    }
}
