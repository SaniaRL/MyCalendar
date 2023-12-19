package GUI.View;

import GUI.ColorSettings;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.time.LocalDate;

public class DayView extends View {

    ColorSettings colorSettings;
    LocalDate date;

    JPanel northPanel;
    JPanel centerPanel;
    JPanel southPanel;

    JLabel dayPanel;

    public DayView(ColorSettings colorSettings, LocalDate date){
        this.colorSettings = colorSettings;
        this.date = date;

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();

        dayPanel = new JLabel(String.valueOf(date.getDayOfWeek()), SwingConstants.CENTER);

        createView();
    }

    public void createView() {
        removeAll();
        setLayout(new BorderLayout());
        setOpaque(false);

        buildNorthPanel();
        buildCenterPanel();
        buildSouthPanel();
    }

    @Override
    public void setDetails() {
        createView();
        repaint();
        revalidate();
    }

    @Override
    public void navigate(int i) {
        date = date.plusDays(i);
    }

    @Override
    public LocalDate getDate() {
        return date;
    }

    public void buildNorthPanel(){
        northPanel.setLayout(new GridLayout(3, 1));
        dayPanel.setText(String.valueOf(date.getDayOfWeek()));
        dayPanel.setFont(new Font("Sans Serif", Font.BOLD, 24));
//        northPanel.setOpaque(false);
        northPanel.add(dayPanel);
        northPanel.setOpaque(false);
        add(northPanel, BorderLayout.NORTH);

    }
    public void buildCenterPanel(){
        centerPanel.setLayout(new BorderLayout());
        centerPanel.setOpaque(false);

        JPanel middlePanel = new JPanel(new GridLayout(8, 1));
//        middlePanel.setBackground(colorSettings.getTodayBackgroundColor());
        middlePanel.setOpaque(false);
        JPanel emptyPanel1 = buildEmptySidePanels();
        JPanel emptyPanel2 = buildEmptySidePanels();

        centerPanel.add(emptyPanel1, BorderLayout.WEST);
        centerPanel.add(emptyPanel2, BorderLayout.EAST);
        centerPanel.add(middlePanel, BorderLayout.CENTER);

        for(int i = 0; i < 8; i++){
            JLabel label = new JLabel(String.valueOf(i), SwingConstants.CENTER);
            Border border = new LineBorder(colorSettings.getWeekdayForegroundColor(), 2);
            label.setBackground(colorSettings.getWeekdayBackgroundColor());
            Border empty = BorderFactory.createEmptyBorder(2,2,2,2);
            Border compound = new CompoundBorder(empty, border);

            label.setBorder(compound);
            middlePanel.add(label);
            add(centerPanel, BorderLayout.CENTER);
        }

    }

    public JPanel buildEmptySidePanels(){
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(50, 50));
        panel.setOpaque(false);

        return panel;
    }
    public void buildSouthPanel(){

    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setColorSettings(ColorSettings colorSettings) {
        this.colorSettings = colorSettings;
    }
}
