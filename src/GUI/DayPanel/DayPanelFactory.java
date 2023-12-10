package GUI.DayPanel;

import GUI.ColorSettings;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DayPanelFactory {
    public DayPanel createDayPanel(boolean currentMonth, LocalDate date, ColorSettings colorSettings){
        if(!currentMonth){
            return new OutsideMonthPanel(date, colorSettings);
        }
        else if(date.equals(LocalDate.now())){
            return new TodayPanel(date, colorSettings);
        }
        else if(isWeekend(date)){
            return new WeekendPanel(date, colorSettings);
        }
        else{
            return new WeekDayPanel(date, colorSettings);
        }
    }

    public boolean isWeekend(LocalDate date){
        return date.getDayOfWeek() == DayOfWeek.SUNDAY;
    }
}