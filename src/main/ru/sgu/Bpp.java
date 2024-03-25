package main.ru.sgu;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Bpp {
    
    private int[] arr;


    public Bpp(int n) {
        arr = generateRandomArray(n);
    }


    private int[] generateRandomArray(int n) {
        Random random = new Random();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }


    private int findThirdSmallest(int[] sortedArr) {
        return Arrays.stream(sortedArr)
                     .skip(2)
                     .toArray()[0];
    }

    private int findSecondLargest(int[] sortedArr) {
        return Arrays.stream(sortedArr)
                     .skip(arr.length - 2)
                     .toArray()[0];
    }

    private String printArray() {
        return Arrays.toString(arr);
    }

    private void run() {
        System.out.println("Был сгенерирован массив случайных чисел:\n" + printArray());
        Arrays.sort(arr);
        if (arr.length < 2) {
            System.out.println("В данном массиве невозможно определить второе наибольшее и третье наименьшие числа.");
        } 
        else if (arr.length == 2) {
            int secondLargest = arr[1];
            System.out.println("Второе наибольшее число: " + secondLargest +
                               "\nВ данном массиве невозможно найти третье наименьшее число.");
        }
        else if (arr.length == 3) {
            int secondLargest = arr[2];
            int thirdSmallest = arr[0];
            System.out.println("Второе наибольшее число: " + secondLargest +
                               "\nТретье наименьшее число: " + thirdSmallest);
        }
        else {
            int secondLargest = findSecondLargest(arr);
            int thirdSmallest = findThirdSmallest(arr);
            System.out.println("Второе наибольшее число: " + secondLargest +
                               "\nТретье наименьшее число: " + thirdSmallest);
        }
    }



    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Введите значение числа n (длина массива случайных чисел): ");
            int n = in.nextInt();
            if (n < 0) 
                System.out.println("\nЧисло n должно быть неотрицательным числом");
            else {
                new Bpp(n).run();
            }
        } 
        catch (InputMismatchException e) {
            System.out.println("\nНекорректный ввод числа n");
        } 
    }
}
