import main.ru.sgu.App;

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
                    App a = new App(filename);
                    a.run();
                }   
                else if (bl == 2) {
                    
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