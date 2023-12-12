package GUI.DayPanel;

import GUI.ColorSettings;

import javax.swing.border.LineBorder;
import java.time.LocalDate;

public class OutsideMonthPanel extends DayPanel {

    public OutsideMonthPanel(LocalDate date, ColorSettings colorSettings){
        super(date, colorSettings);
        addDetails();
    }

    @Override
    public void addDetails(){
        setBackground(color.getEmptyBackgroundColor());
        dateLabel.setForeground(color.getEmptyForegroundColor());
    }

    @Override
    public void restore(){
        setBorder(border);
        setBackground(color.getEmptyBackgroundColor());
        dateLabel.setForeground(color.getEmptyForegroundColor());
    }

}
