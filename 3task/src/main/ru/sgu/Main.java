package main.ru.sgu;
import java.util.Scanner;

public class Main {
    
    public void chooseMode() {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Сортировка данных в файле." +
                               "\n2. Рекурсивное архивирование." +
                               "\n3. Выход.");
            System.out.print("Выберите опцию: ");
            String bl = in.next();
            in.nextLine();
            if (bl.equals("1")) {
                System.out.println("Введите имя файла:");
                String filename = in.next();
                App a = new App();
                filename = "tests/input.txt";
                a.processFile(filename);
                if (a.dataCheck()) 
                    a.run();
            }   
            else if (bl.equals("2")) {
                System.out.print("Введите название архивируемой директории: ");
                String path = in.next();
                System.out.print("Введите имя целевой строки: ");
                String target = in.next();
                Bpp b = new Bpp(path, target);
                if (b.dirValidalityCheck()) {
                    System.out.println("Начало архивации...");
                    b.run();
                    System.out.println("Архивация прошла успешно");
                }
            }
            else if (bl.equals("3")) {
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