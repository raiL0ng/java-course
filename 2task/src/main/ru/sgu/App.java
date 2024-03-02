package main.ru.sgu;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class App {

    private final LocalDate mindate, maxdate;


    public App(String[] date1, String[] date2) {
        this.mindate = dateParser(date1);
        this.maxdate = dateParser(date2);
    }


    private LocalDate dateParser(String[] strdate) {
        if (strdate.length != 3) {
            return null;
        }
        LocalDate date;
        try {
            int y, m, d;
            y = Integer.parseInt(strdate[0]);
            m = Integer.parseInt(strdate[1]);
            d = Integer.parseInt(strdate[2]);
            date = LocalDate.of(y, m, d);
        } catch (Exception e) {
            return null;
        }
        return date;
    }


    public boolean checkTrueDates() {
        if (this.mindate == null || this.maxdate == null)
            return false;
        return true;
    }


    public long getResult() {
        return Math.abs(ChronoUnit.DAYS.between(this.mindate, this.maxdate));
    }
}