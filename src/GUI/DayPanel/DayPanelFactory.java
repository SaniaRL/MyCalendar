package GUI.DayPanel;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DayPanelFactory {
    public DayPanel createDayPanel(boolean currentMonth, LocalDate date){
        if(!currentMonth){
            return new OutsideMonthPanel(date);
        }
        else if(isWeekend(date)){
            return new WeekendPanel(date);
        }
        else{
            return new WeekDayPanel(date);
        }
    }

    public boolean isWeekend(LocalDate date){
        return date.getDayOfWeek() == DayOfWeek.SUNDAY;
    }
}