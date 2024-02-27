package main.ru.sgu;

import java.util.Random;

public class Cpp {

    public Random rand = new Random();
    public final int len = 10;

    public String getRandomString() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        Random random = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }
    // поменять названия
    public void stringGeneration1() {
        String example1 = new String();
        for (int i = 0; i < 100000; i++) {
            example1 += getRandomString();
        }
    }

    public void stringGeneration2() {
        StringBuilder example2 = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            example2.append(getRandomString());
        }
    }

    public void stringGeneration3() {
        StringBuffer example3 = new StringBuffer();
        for (int i = 0; i < 100000; i++) {
            example3.append(getRandomString());
        }
    }
    public void run() {
        long start = System.currentTimeMillis();
        stringGeneration1();
        System.out.println("Время выполнения (String): " + ((System.currentTimeMillis() - start)));
        
        start = System.currentTimeMillis();
        stringGeneration2();
        System.out.println("Время выполнения (StringBuilder): " + ((System.currentTimeMillis() - start)));
        
        start = System.currentTimeMillis();
        stringGeneration3();
        System.out.println("Время выполнения (StringBuffer): " + ((System.currentTimeMillis() - start)));
    }
}