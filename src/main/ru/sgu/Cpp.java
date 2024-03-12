package main.ru.sgu;

import java.util.Random;

public class Cpp {

    private Random rand = new Random();
    private final int len = 10;

    private String getRandomString() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            int index = this.rand.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }


    private void classStringGeneration() {
        String str = new String();
        for (int i = 0; i < 100000; i++) {
            str += getRandomString();
        }
    }


    private void classStringBuilderGeneration() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            str.append(getRandomString());
        }
    }


    private void classStringBufferGeneration() {
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < 100000; i++) {
            str.append(getRandomString());
        }
    }


    public void run() {
        long start = System.currentTimeMillis();
        classStringGeneration();
        System.out.println("Время выполнения (String): " + ((System.currentTimeMillis() - start)));
        
        start = System.currentTimeMillis();
        classStringBuilderGeneration();
        System.out.println("Время выполнения (StringBuilder): " + ((System.currentTimeMillis() - start)));
        
        start = System.currentTimeMillis();
        classStringBufferGeneration();
        System.out.println("Время выполнения (StringBuffer): " + ((System.currentTimeMillis() - start)));
    }
}