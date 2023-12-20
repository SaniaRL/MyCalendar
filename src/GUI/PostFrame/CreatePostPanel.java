package GUI.PostFrame;

import FileManager.FileOperation;
import GUI.ColorSettings;
import FileManager.FileOperationType;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.IOException;
import java.time.LocalDate;

public class CreatePostPanel extends EntryPanel implements FileOperation {

    JPanel northPanel;
    JPanel centerPanel;
    JPanel southPanel;
    JTextField textField;
    JTextArea textArea;
    JScrollPane scrollPane;

    JButton save;
    JButton back;

    public CreatePostPanel(ColorSettings colorSettings, LocalDate date){
        super(colorSettings, date);
        northPanel = new JPanel(new GridLayout(1, 3));
        centerPanel = new JPanel();
        textField = new JTextField();
        textArea = new JTextArea(100, 20);
        scrollPane = new JScrollPane(textArea);

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
        northPanel.add(textField);
        textField.setFont(new Font("Sans Serif", Font.BOLD, 30));
        textField.setPreferredSize(new Dimension(350, 60));
        northPanel.setBorder(new LineBorder(colorSettings.getBorderColor()));
        add(northPanel, BorderLayout.NORTH);
    }

    public void buildCenterPanel(){
        add(centerPanel, BorderLayout.CENTER);
        centerPanel.add(scrollPane);
        textArea.setLineWrap(true);
        textArea.setFont(new Font("Sans Serif", Font.PLAIN, 22));
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(380, 400));

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

    public void saveToFile(String dateString, String category, String title, String content) {

        String entry = dateString + regex + category + regex + title +regex + content + "\n";

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

    public void fileOperations(FileOperationType fileOperationType){
        String dateString = String.valueOf(date);
        String category = "Diary";
        String title = textField.getText();
        textField.setText("");
        String content = textArea.getText();
        textArea.setText("");

        switch (fileOperationType){
            case READ -> System.out.println("READ");
            case WRITE -> {
                if(!checkIfTextContainsRegex(content)){
                    saveToFile(dateString, category, title, content);
                }
                else{
                    System.out.println("Contains regex");
                }
            }
            case ACCESS -> System.out.println("ACCESS");
        }
    }

    @Override
    public void fileOperation(FileOperationType fileOperationType) {
        System.out.println("CreatePostPanel::fileOperation");
    }
}
