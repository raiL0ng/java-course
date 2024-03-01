package main.ru.sgu;
import java.util.Scanner;

public class Main {
    
    public void chooseMode() {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Вывести \"Hello world.\"." +
                               "\n2. Выполнить арифметические операции." +
                               "\n3. Обработать файл с данными." +
                               "\n4. Выход.");
            System.out.print("Выберите опцию: ");
            String bl = in.next();
            in.nextLine();
            if (bl.equals("1")) {
                App a = new App();
                a.run();
            }   
            else if (bl.equals("2")) {
                Bpp b = new Bpp();
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