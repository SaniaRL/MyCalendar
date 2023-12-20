package GUI.PostFrame;

import GUI.CalendarEntry.CalendarEntry;
import GUI.CalendarEntry.Category;
import GUI.CalendarEntry.DiaryEntry;
import GUI.ColorSettings;
import FileManager.FileOperation;
import FileManager.FileOperationType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.time.LocalDate;

public class DayViewPanel extends EntryPanel implements DayViewPanelParent, FileOperation {

    ImageIcon icon;

    JPanel northPanel;
    JPanel centerPanel;
    JLabel dayLabel;
    JLabel monthYearLabel;
    JButton newPost;

    List<Category> categoryList;
    Category category;

    //TODO make sure regex does not exist in different classes
//    String regex;
    DayViewPanelParent parent;

    List<CalendarEntry> calendarEntries;

    public DayViewPanel(ColorSettings colorSettings, LocalDate date, DayViewPanelParent dayViewPanelParent){
        super(colorSettings, date);
        parent = dayViewPanelParent;
        icon = new ImageIcon("Icons/7.png");
        northPanel = new JPanel(new GridLayout(1, 3));
        centerPanel = new JPanel();
        dayLabel = new JLabel("", SwingConstants.CENTER);
        monthYearLabel = new JLabel();
        newPost = new JButton("+");
        category = new Category("Diary", "Diary.txt", new Color(175, 102, 250));
        //TODO Get by method from other class that holds the Categories
        categoryList = new ArrayList<>();
        categoryList.add(category);
        calendarEntries = new ArrayList<>();
//        regex = ";;";

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

    public void buildPostButtons() throws IOException {

    }

    public void addActionListenerToButtons() {
        newPost.addActionListener(e -> buttonClicked());
    }

    @Override
    public void buttonClicked() {
        parent.buttonClicked();
    }

    @Override
    public void fileOperation(FileOperationType fileOperationType) {
        List<String> categoryPaths = new ArrayList<>();
        for(Category categoryTemp : categoryList){
            categoryPaths.add(categoryTemp.getPath());
        }

        List<String> data = fileManager.getDataByDate(categoryPaths, date, regex, 0);
        if(!data.isEmpty()){
            for(String postData : data){
                String[] dataArray = postData.split(regex);
                if(dataArray[1].trim().equalsIgnoreCase("diary")){
                    calendarEntries.add(new DiaryEntry(date, dataArray[2], dataArray[3]));
                }
            }
        }
    }

    public void setColorSettings(ColorSettings colorSettings) {
        this.colorSettings = colorSettings;
        setBackground(colorSettings.getColor());
    }
}
