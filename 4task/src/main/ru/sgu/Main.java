package main.ru.sgu;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

public class Main {
    
    public void chooseMode() {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Реализация потоков." +
                               "\n2. Найти n-е число Фибоначчи." +
                               "\n3. Реализация producer/consumer." +
                               "\n4. Выход.");
            System.out.print("Выберите опцию: ");
            String bl = in.next();
            if (bl.equals("1")) {
                System.out.print("Введите значение числа: ");
                BigDecimal n = new BigDecimal(in.next());
                new App(n).run();
            }   
            else if (bl.equals("2")) {
                System.out.print("Введите значение числа n (n-е число Фибоначчи): ");
                BigInteger n = new BigInteger(in.next());
                if (n.compareTo(BigInteger.ZERO) >= 0) {
                    ForkJoinPool fjp = new ForkJoinPool();
                    BigInteger res = fjp.invoke(new Bpp(n));
                    System.out.println(n + "-е число Фибоначчи: " + res);
                    fjp.close();
                } else {
                    System.out.println("Число n должно быть неотрицательным");
                }
                
            }
            else if (bl.equals("3")) {
                System.out.println("\nДобро пожаловать в столовую!\n");
                System.out.print("Введите количество производителей: ");
                int pn = in.nextInt();
                System.out.print("Введите количество покупателей: ");
                int cn = in.nextInt();
                System.out.print("Установите время работы очереди: ");
                int d = in.nextInt();
                Cpp c = new Cpp(pn, cn, d);
                if (c.checkValues()) {
                    c.run();
                } else {
                    System.out.println("Числа для ввода должны быть неоотрицательными");
                }
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