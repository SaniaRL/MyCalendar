package GUI.PostFrame;

import GUI.ColorSettings;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.time.LocalDate;

public class DayViewPanel extends EntryPanel implements DayViewPanelParent {

    ImageIcon icon;

    JPanel northPanel;
    JPanel centerPanel;
    JPanel southPanel;
    JLabel dayLabel;
    JLabel monthYearLabel;
    JButton newPost;

    JButton category;

    DayViewPanelParent parent;

    public DayViewPanel(ColorSettings colorSettings, LocalDate date, DayViewPanelParent dayViewPanelParent){
        super(colorSettings, date);
        parent = dayViewPanelParent;
        icon = new ImageIcon("Icons/7.png");
        northPanel = new JPanel(new GridLayout(1, 3));
        centerPanel = new JPanel();
        dayLabel = new JLabel("", SwingConstants.CENTER);
        monthYearLabel = new JLabel();
        newPost = new JButton("+");

        buildPanel();
    }

    public void buildPanel(){
        setSize(new Dimension(400, 600));
        setLayout(new BorderLayout());
        setBackground(colorSettings.getColor());

        buildNorthPanel();
        buildCenterPanel();
        addActionListenerToButtons();

        setVisible(true);
    }

    public void buildNorthPanel(){

        northPanel.setBackground(colorSettings.getWeekdayBackgroundColor());
        northPanel.setBorder(new LineBorder(colorSettings.getBorderColor()));

        northPanel.add(newPost);
        northPanel.add(dayLabel);
        northPanel.add(monthYearLabel);
        add(northPanel, BorderLayout.NORTH);

        newPost.setBackground(colorSettings.getTodayBackgroundColor());
        dayLabel.setText(date.getDayOfWeek().toString());
        monthYearLabel.setText(date.toString());
    }

    public void buildCenterPanel(){
        add(centerPanel, BorderLayout.CENTER);
    }

    public void buildSouthPanel(){
        southPanel = new JPanel(new GridLayout(1, 2));
        southPanel.setBackground(colorSettings.getWeekendBackgroundColor());
        buildPostButtons();

        category = new JButton("Category");

        add(southPanel, BorderLayout.SOUTH);
    }
    public void buildPostButtons(){

    }

    public void addActionListenerToButtons() {
        newPost.addActionListener(e -> buttonClicked());
    }

    @Override
    public void buttonClicked() {
        parent.buttonClicked();
    }
}
