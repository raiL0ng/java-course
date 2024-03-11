package main.ru.sgu;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class App {

    private LocalDate mindate, maxdate;


    private LocalDate dateParser(String[] strdate) {
        if (strdate.length != 3) {
            return null;
        }
        LocalDate date;
        int y = -1, m = -1, d = -1;
        try {
            y = Integer.parseInt(strdate[0]);
            m = Integer.parseInt(strdate[1]);
            d = Integer.parseInt(strdate[2]);
            date = LocalDate.of(y, m, d);
        } catch (NumberFormatException e) {
            if (y == -1) {
                System.out.println("\nНеправильный ввод дня!");
                return null;
            }
            if (m == -1) {
                System.out.println("\nНеправильный ввод дня!");
                return null;
            }
            if (d == -1) {
                System.out.println("\nНеправильный ввод дня!");
                return null;
            }
            return null;
        } catch (DateTimeException e){
            System.out.println("\nНеправильный ввод данных!");
            return null;
        }
        return date;
    }


    public boolean getAndCheckFirstDate(String[] date) {
        this.mindate = dateParser(date);
        return !(this.mindate == null);
    }


    public boolean getAndCheckSecondDate(String[] date) {
        this.maxdate = dateParser(date);
        return !(this.maxdate == null);
    }


    public long getResult() {
        return Math.abs(ChronoUnit.DAYS.between(this.mindate, this.maxdate));
    }
}