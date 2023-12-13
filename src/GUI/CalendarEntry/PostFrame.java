package GUI.CalendarEntry;

import GUI.ColorSettings;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.time.LocalDate;

public class PostFrame extends JFrame {
    ColorSettings colorSettings;
    LocalDate date;
    ImageIcon icon;

    JPanel contentPanel;
    JPanel northPanel;
    JPanel centerPanel;
    JPanel southPanel;
    JLabel dayLabel;
    JLabel monthYearLabel;
    JButton newPost;
    JTextArea textArea;
    JScrollPane scrollPane;

    FileManager fileManager;

    public PostFrame(ColorSettings colorSettings){
        this.colorSettings = colorSettings;
        icon = new ImageIcon("Icons/7.png");
        contentPanel = new JPanel(new BorderLayout());
        northPanel = new JPanel(new GridLayout(1, 3));
        centerPanel = new JPanel();
        southPanel = new JPanel();
        dayLabel = new JLabel("", SwingConstants.CENTER);
        monthYearLabel = new JLabel();
        newPost = new JButton("+");
        textArea = new JTextArea(100, 1);
        scrollPane = new JScrollPane(textArea);
        fileManager = FileManager.getInstance();
    }

    public void buildFrame(LocalDate date){
        this.date = date;
        setSize(new Dimension(400, 600));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setIconImage(icon.getImage());
        setResizable(false);

        contentPanel.setBackground(colorSettings.getColor());
        add(contentPanel);

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
        contentPanel.add(northPanel, BorderLayout.NORTH);

        newPost.setBackground(colorSettings.getTodayBackgroundColor());
        dayLabel.setText(date.getDayOfWeek().toString());
        monthYearLabel.setText(date.toString());
    }

    public void buildCenterPanel(){
        contentPanel.add(centerPanel, BorderLayout.CENTER);

        southPanel.setBackground(colorSettings.getWeekendBackgroundColor());
        buildPostButtons();

    }

    public void buildSouthPanel(){

    }

    public JButton buildOptionButtons(){
        return new JButton();
    }

    public void buildPostButtons(){

    }

    public void addActionListenerToButtons() {
        newPost.addActionListener(e -> openTextArea());

    }

    public void openTextArea(){
        System.out.println("Open Text Area");
        buildSouthPanel();

        centerPanel.removeAll();
        centerPanel.add(scrollPane);
        scrollPane.setPreferredSize(new Dimension(380, 500));
        centerPanel.repaint();
        centerPanel.revalidate();
    }
}