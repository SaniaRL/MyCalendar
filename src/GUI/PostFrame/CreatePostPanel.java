package GUI.PostFrame;

import GUI.ColorSettings;
import GUI.FileManager;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.time.LocalDate;

public class CreatePostPanel extends JPanel {

    ColorSettings colorSettings;
    LocalDate date;

    JPanel northPanel;
    JPanel centerPanel;
    JPanel southPanel;
    JTextArea textArea;
    JScrollPane scrollPane;

    JButton save;
    JButton back;

    FileManager fileManager;

    public CreatePostPanel(ColorSettings colorSettings, LocalDate date){
        this.colorSettings = colorSettings;
        this.date = date;
        northPanel = new JPanel(new GridLayout(1, 3));
        centerPanel = new JPanel();
        textArea = new JTextArea(100, 1);
        scrollPane = new JScrollPane(textArea);
        fileManager = FileManager.getInstance();

        buildPanel();
    }

    public void buildPanel(){
        setSize(new Dimension(400, 600));
        setBackground(colorSettings.getColor());

        buildNorthPanel();
        buildCenterPanel();
        buildSouthPanel();
        addActionListenerToButtons();

        setVisible(true);
    }

    public void buildNorthPanel(){

        northPanel.setBorder(new LineBorder(colorSettings.getBorderColor()));

        centerPanel.add(scrollPane);
        scrollPane.setPreferredSize(new Dimension(380, 500));

        add(northPanel, BorderLayout.NORTH);
    }

    public void buildCenterPanel(){
        add(centerPanel, BorderLayout.CENTER);
    }

    public void buildSouthPanel(){
        southPanel = new JPanel(new GridLayout(1, 2));
        southPanel.setBackground(colorSettings.getWeekendBackgroundColor());

        save = new JButton("Save");
        back = new JButton("Back");

        southPanel.add(save);
        southPanel.add(back);
        add(southPanel, BorderLayout.SOUTH);
    }

    public void addActionListenerToButtons() {

    }
}
