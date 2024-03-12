package main.ru.sgu;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class App {

    private LocalDate mindate, maxdate;


    private LocalDate dateParser(String[] strdate) {
        if (strdate.length != 3) {
            System.out.println("Некорректный формат даты!");
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
            if (y == -1)
                System.out.println("\nНеправильный ввод года!");
            if (m == -1)
                System.out.println("\nНеправильный ввод месяца!");
            if (d == -1)
                System.out.println("\nНеправильный ввод дня!");
            return null;
        } catch (Exception e){
            System.out.println("\nНекорректный формат даты!");
            return null;
        }
        return date;
    }


    public void setFirstDate(String[] date) {
        this.mindate = dateParser(date);
    }


    public boolean checkFirstDate() {
        return !(this.mindate == null);
    }


    public void setSecondDate(String[] date) {
        this.maxdate = dateParser(date);
    }

    
    public boolean checkSecondDate() {
        return !(this.maxdate == null);
    }

    public long getResult() {
        return Math.abs(ChronoUnit.DAYS.between(this.mindate, this.maxdate));
    }
}