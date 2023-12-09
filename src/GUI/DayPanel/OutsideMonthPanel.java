package GUI.DayPanel;

import java.time.LocalDate;

public class OutsideMonthPanel extends DayPanel {

    public OutsideMonthPanel(LocalDate date){
        super(date);
        setBackground(color.getEmptyBackgroundColor());
        dateLabel.setForeground(color.getEmptyForegroundColor());
    }
}
