import main.ru.sgu.App;
import main.ru.sgu.Bpp;

import java.util.Scanner;

public class Main {
    
    public void chooseMode() {
        Scanner in = new Scanner(System.in);
        try {
            while (true) {

                System.out.println("\n1. Сортировка данных в файле.");
                System.out.println("2. Рекурсивное архивирование.");
                System.out.println("3. Выход.");
                System.out.print("Выберите опцию: ");
                int bl = in.nextInt();
                if (bl == 1) {
                    System.out.println("Введите имя файла:");
                    String filename = in.next();
                    App a = new App();
                    a.processFile(filename);
                    a.run();
                }   
                else if (bl == 2) {
                    System.out.print("Введите название архивируемой директории: ");
                    String path = in.next();
                    System.out.print("Введите имя целевой строки: ");
                    String target = in.next();
                    System.out.println("Начало архивации...");
                    if (new Bpp(path, target).run()) {
                        System.out.println("Архивация прошла успешно");
                    }
                }
                else if (bl == 3) {
                    break;
                }
            }
        }
        catch (Exception e){
               System.out.println("\nОшибка ввода чисел!!!");
        }
        in.close();
    }

    public static void main(String[] args) throws Exception {
        Main a = new Main();
        a.chooseMode();
    }
}