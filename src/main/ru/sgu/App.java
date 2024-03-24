package main.ru.sgu;


import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.function.IntPredicate;


public class App {
    
    private int leftBoundary, rightBoundary;
    private IntStream stream;
    private Scanner in = new Scanner(System.in);


    public App(int l, int r) {
        this.leftBoundary = l;
        this.rightBoundary = r;
    }


    public boolean checkBoundaries() {
        if (leftBoundary > rightBoundary) {
            System.out.println("Некорректный ввод!\nЗначение левой границы превышает значение правой границы.");
            return false;
        }
        return true;
    }

    public void chooseMode() {
        stream = IntStream.range(leftBoundary, rightBoundary);
        System.out.println("Выберите способ фильтрации числа:\n" +
                           "1. Вывести только четные числа.\n" +
                           "2. Вывести только нечетные числа.\n" +
                           "3. Вывести числа большие заданного числа.\n" +
                           "4. Вывести числа меньшие заданного числа.\n" +
                           "5. Вывести числа кратные заданному числу."
                          );
        String bl = in.next();
        in.nextLine();
        if (bl.equals("1")) {
            IntPredicate isEven = x -> (x % 2) == 0;
            System.out.println("Результат: ");
            String result = stream.filter(isEven)
                            .mapToObj(String::valueOf)
                            .collect(Collectors.joining(", ", "[", "]"));
            System.out.println(result + "\n");
        }  
        else if (bl.equals("2")) {
            IntPredicate isOdd = x -> (x % 2) == 1;
            System.out.println("Результат: ");
            String result = stream.filter(isOdd)
                            .mapToObj(String::valueOf)
                            .collect(Collectors.joining(", ", "[", "]"));
            System.out.println(result + "\n");
        }
        else if (bl.equals("3")) {
            System.out.print("Введите число для обработки: ");
            int num = in.nextInt();
            IntPredicate moreThenNum = x -> x > num;
            System.out.println("Результат: ");
            String result = stream.filter(moreThenNum)
                            .mapToObj(String::valueOf)
                            .collect(Collectors.joining(", ", "[", "]"));
            System.out.println(result + "\n");
        }
        else if (bl.equals("4")) {
            System.out.print("Введите число для обработки: ");
            int num = in.nextInt();
            IntPredicate lessThenNum = x -> x < num;
            System.out.println("Результат: ");
            String result = stream.filter(lessThenNum)
                            .mapToObj(String::valueOf)
                            .collect(Collectors.joining(", ", "[", "]"));
            System.out.println(result + "\n");
        }
        else if (bl.equals("5")) {
            System.out.print("Введите число для обработки: ");
            int num = in.nextInt();
            IntPredicate multipleNum = x -> x % num == 0;
            System.out.println("Результат: ");
            String result = stream.filter(multipleNum)
                            .mapToObj(String::valueOf)
                            .collect(Collectors.joining(", ", "[", "]"));
            System.out.println(result + "\n");
        } 
        else {
            System.out.println("\nНекорректный ввод номера способа фильтрации!\n" +
                               "Завершение работы программы...");   
        }
    }


    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)){
            System.out.print("Введите два числа через пробел - границы массива/потока: ");
            int left = in.nextInt();
            int right = in.nextInt();
            App a = new App(left, right);
            if (a.checkBoundaries()) {
                a.chooseMode();
            }
        }
        catch (Exception e) {
            System.out.println("При выполнении программы произошла ошибка:\n" + e.getMessage());
        }
    }
}