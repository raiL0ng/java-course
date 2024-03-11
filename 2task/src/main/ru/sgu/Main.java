package main.ru.sgu;
import java.util.Scanner;

public class Main {
    
    public void chooseMode() {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Вычисление числа дней." +
                               "\n2. Узнать день недели." +
                               "\n3. Генерация строки." +
                               "\n4. Выход.");
            System.out.print("Выберите опцию: ");
            String bl = in.next();
            in.nextLine();
            if (bl.equals("1")) {
                App a = new App();
                System.out.println("Введите даты в формате \"год месяц день\":\nПервая дата:");
                String[] date1 = in.nextLine().split(" ");
                if (!a.getAndCheckFirstDate(date1)) {
                    continue;
                }
                System.out.println("Вторая дата:");
                String[] date2 = in.nextLine().split(" ");
                if (!a.getAndCheckSecondDate(date2)) {
                    continue;
                }
                long ans = a.getResult();
                System.out.println("Количество дней между данным временным промежутком:\n" + ans);
            }   
            else if (bl.equals("2")) {
                System.out.println("Введите имя дня недели и количество дней:");
                String dayOfWeek = in.next().toLowerCase();
                int num = in.nextInt();
                Bpp b = new Bpp(dayOfWeek, num);
                b.run();
            }
            else if (bl.equals("3")) {
                Cpp c = new Cpp();
                c.run();
            }
            else if (bl.equals("4")) {
                in.close();
                break;
            }
            else {
                System.out.println("\nНекорректный ввод!");
            }
        }
    }


    public static void main(String[] args) throws Exception {
        Main a = new Main();
        a.chooseMode();
    }
}