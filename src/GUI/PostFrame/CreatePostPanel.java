package GUI.PostFrame;

import GUI.ColorSettings;
import GUI.FileOperationType;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.IOException;
import java.time.LocalDate;

public class CreatePostPanel extends EntryPanel {

    JPanel northPanel;
    JPanel centerPanel;
    JPanel southPanel;
    JTextArea textArea;
    JScrollPane scrollPane;

    JButton save;
    JButton back;

    String regex;

    public CreatePostPanel(ColorSettings colorSettings, LocalDate date){
        super(colorSettings, date);
        northPanel = new JPanel(new GridLayout(1, 3));
        centerPanel = new JPanel();
        textArea = new JTextArea(100, 20);
        scrollPane = new JScrollPane(textArea);
        regex = ";;";

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
        textArea.setLineWrap(true);
        textArea.setFont(new Font("Sans Serif", Font.PLAIN, 22));
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
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
        save.addActionListener(e -> fileOperations(FileOperationType.WRITE));

    }

    public void saveToFile(String dateString, String category, String content) {

        String entry = dateString + regex + category + regex + content + "\n";

        try{
            fileManager.writeToFile("Persistence/Diary.txt", entry);
        }catch (IOException e){
            System.out.println("Error");
        }
    }

    public boolean checkIfTextContainsRegex(String text){
        boolean containsRegex = true;
        if(!text.contains(regex)){
            return false;
        }
        return containsRegex;
    }

    //TODO make sure it's not only diary
    @Override
    public void fileOperations(FileOperationType fileOperationType){
        String dateString = String.valueOf(date);
        String category = "Diary";
        String content = textArea.getText();
        textArea.setText("");

        switch (fileOperationType){
            case READ -> System.out.println("READ");
            case WRITE -> {
                if(!checkIfTextContainsRegex(content)){
                    saveToFile(dateString, category, content);
                }
                else{
                    System.out.println("Contains regex");
                }
            }
            case ACCESS -> System.out.println("ACCESS");
        }
    }
}
