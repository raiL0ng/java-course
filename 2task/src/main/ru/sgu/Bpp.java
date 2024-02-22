package main.ru.sgu;

import java.util.Scanner;

public class Bpp {

    public static String[] daysOfWeek = { "null", "monday", "tuesday", "wednesday", "thursday"
                          , "friday", "saturday", "sunday" };
    public static boolean dataCheck(String dayOfWeek, int num) {
        boolean fl = false;
        for (int i = 0; i < 8; i++) {
            if (dayOfWeek.equals(daysOfWeek[i]))
                fl = true;
        }
        if (!fl || num < 0)
            return false;
        return true; 
    } 

    public static void main(String[] args) throws Exception {
        System.out.println("Введите имя дня недели и количество дней:");
        Scanner in = new Scanner(System.in);
        String newDay, dayOfWeek = in.next().toLowerCase();
        int num = in.nextInt();
        if (dataCheck(dayOfWeek, num)) {
            newDay = daysOfWeek[num % 7];
            if (newDay.equals("null"))
                newDay = dayOfWeek;
            System.out.printf("Через %s дней(-я) будет следующий день недели:\n%s\n", num, newDay);
        }
        in.close();

    }
}
