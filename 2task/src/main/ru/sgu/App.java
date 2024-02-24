package main.ru.sgu;

import java.math.BigInteger;
import java.util.Scanner;

public class App {

    private int[] monthsDays = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int[] dateParser(Scanner in) {
        int[] date = new int[3];
        try {
            int tmp;
            for (int i = 0; i < 3; i++) {
                tmp = in.nextInt();
                if (i == 0) {
                    if (tmp > 0 && tmp < 10000)
                        date[i] = tmp;
                    else {
                        System.out.println("Некорректный ввод даты (неверно введен год)!");
                        return new int[] {-1};
                    }
                }
                if (i == 1) {
                    if (tmp > 0 && tmp < 13) 
                        date[i] = tmp;
                    else {
                        System.out.println("Некорректный ввод даты (неверно введен месяц)!");
                        return new int[] {-1};
                    }
                }
                if (i == 2) {
                    if (tmp > 0 && tmp < 32)
                        date[i] = tmp;
                    else {
                        System.out.println("Некорректный ввод даты (неверно введен день)!");
                        return new int[] {-1};


                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Некорректный ввод даты!");
            return new int[] {-1};
        }
        return date;
    }

    public int countDaysInOneYear(int[] date) {
        int days = 0;
        for (int i = 1; i < date[1]; i++) {
            days += monthsDays[i];
            if (date[0] % 4 == 0 && i == 2)
                days++;
        }
        days += date[2];
        System.out.println("days=" + days);
        return days;
    }

    public BigInteger getResult(int[] mindate, int[] maxdate) {
        BigInteger cntDays = BigInteger.ZERO, d = new BigInteger("365");
        for (int year = 0; year < maxdate[0] - mindate[0] + 1; year++) {
            cntDays = cntDays.add(d);
            if (year % 4 == 0)
                cntDays = cntDays.add(BigInteger.ONE);
        }
        
        cntDays = cntDays.subtract(new BigInteger(Integer.toString(countDaysInOneYear(mindate))));
        System.out.println("after mindate " + cntDays);
        cntDays = cntDays.subtract(d.subtract(new BigInteger(Integer.toString(countDaysInOneYear(maxdate) - 1))));    
        return cntDays;
    }

    public void run() {
        System.out.println("Введите даты в формате \"год меяц день\":\nМинимальная дата:");
        Scanner in = new Scanner(System.in);
        int[] mindate = dateParser(in);
        if (mindate[0] == -1)
            return;
        System.out.println("Максимальная дата:");
        int[] maxdate = dateParser(in);
        if (maxdate[0] == -1)
            return;
        BigInteger ans = getResult(mindate, maxdate);
        System.out.println("Количество дней между данным временным промежутком:\n" + ans);
        in.close();

    }
}
