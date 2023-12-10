package GUI.DayPanel;

import GUI.ColorSettings;

import java.time.LocalDate;

public class OutsideMonthPanel extends DayPanel {

    public OutsideMonthPanel(LocalDate date, ColorSettings colorSettings){
        super(date, colorSettings);
        setBackground(color.getEmptyBackgroundColor());
        dateLabel.setForeground(color.getEmptyForegroundColor());
    }
}
