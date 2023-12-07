package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class CalendarFrame extends JFrame {

    //Panels
    private final JPanel northPanel;
    private final JPanel centerPanel;

    //Paths
    private final ImageIcon icon;

    //TODO Remove Main
    public static void main(String[] args){
        CalendarFrame calendarFrame = new CalendarFrame();
    }

    public CalendarFrame(){
        northPanel = new JPanel();
        centerPanel = new JPanel();
        icon = new ImageIcon("Icons/calendarIcon.png");
        buildFrame();
    }

    private void buildFrame(){
        setSize(new Dimension(1400, 800));
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("MyCalendar");
        setIconImage(icon.getImage());
        setVisible(true);

        buildCenterPanel();
        add(centerPanel, BorderLayout.CENTER);
    }

    public void buildNorthPanel(){

    }
    public void buildCenterPanel(){
        centerPanel.setLayout(new GridLayout(5, 7));
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
