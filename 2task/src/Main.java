import main.ru.sgu.App;
import main.ru.sgu.Bpp;
import main.ru.sgu.Cpp;

import java.util.Scanner;

public class Main {
    
    public void chooseMode() {
        Scanner in = new Scanner(System.in);
        try {
            while (true) {

                System.out.println("\n1. Вычисление числа дней." +
                                   "\n2. Узнать день недели." +
                                   "\n3. Генерация строки." +
                                   "\n4. Выход.");
                System.out.print("Выберите опцию: ");
                int bl = in.nextInt();
                if (bl == 1) {
                    App a = new App();
                    a.run();
                }   
                else if (bl == 2) {
                    Bpp b = new Bpp();
                    b.run();
                }
                else if (bl == 3) {
                    Cpp c = new Cpp();
                    c.run();
                }
                else if (bl == 4) {
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