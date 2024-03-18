package main.ru.sgu;

import java.math.BigDecimal;


public class App {
    
    private BigDecimal incrementalNumber;
    private final int N = 100000;

    
    class Inc implements Runnable {

        @Override
        public void run() {
            synchronized (this) {
                for (int i = 0; i < N; i++) {
                    incrementalNumber = incrementalNumber.add(BigDecimal.ONE);
                }
            }
        }
    }

    public App(BigDecimal n) {
        this.incrementalNumber = n;
    }

    public void run() {
        Inc inc = new Inc();
        Thread t1 = new Thread(inc);
        Thread t2 = new Thread(inc);
        
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();    
        } catch (InterruptedException e) {
            System.out.println("Что-то пошло не так..." + e.getMessage());
        }
        System.out.println("Конечное значение переменной: " + this.incrementalNumber);
    }
}


