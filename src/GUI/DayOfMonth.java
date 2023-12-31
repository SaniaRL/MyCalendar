package GUI;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DayOfMonth {
    int year;
    int month;

    List<LocalDate> dateList;

    public DayOfMonth(LocalDate date){
        year = date.getYear();
        month = date.getMonthValue();
        dateList = new ArrayList<>();

        addDaysToList();
    }

    public void addDaysToList(){
        dateList.clear();
        LocalDate date = LocalDate.of(year, month, 1);
        LocalDate startDate = countDaysBefore(date);
        for(int i = 0; i < 42; i++){
            dateList.add(startDate.plusDays(i));
        }
    }

    public LocalDate countDaysBefore(LocalDate date){
        //Check how many days after monday the month starts with
        int day = LocalDate.of(year, month, 1).getDayOfWeek().getValue();
        int daysBefore = 7 - (7 - (day - 1));

        return date.minusDays(daysBefore);
    }

    public List<LocalDate> getDateList() {
        return dateList;
    }
}
