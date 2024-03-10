package main.ru.sgu;

import java.math.BigDecimal;


public class App {
    
    private BigDecimal incrementalNumber;
    private final int N = 100000;

    
    class Inc implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < N; i++) {
                synchronized (App.class) {
                    incrementalNumber = incrementalNumber.add(BigDecimal.ONE);
                }
                // setNumberValue();

            }
        }
    }

    public App(BigDecimal n) {
        this.incrementalNumber = n;
    }

    public void run() {
        Thread t1 = new Thread(new Inc());
        Thread t2 = new Thread(new Inc());
        
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

    public void setNumberValue() {
        synchronized (App.class) {
            System.out.println("Поток " + Thread.currentThread().getName() +
                               " изменил значение переменной: " + this.incrementalNumber);
        }
    }
}


