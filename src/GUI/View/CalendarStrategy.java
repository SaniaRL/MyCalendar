package GUI.View;

import java.time.LocalDate;

public interface CalendarStrategy {

    void setDetails();
    void navigate(int i);

    LocalDate getDate();
}
