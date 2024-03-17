package main.ru.sgu;

import java.util.concurrent.BlockingQueue;


public class Consumer implements Runnable {
    
    private final BlockingQueue<Food> queue;
    private int sumCalories = 0;
    private String name;

    public Consumer(BlockingQueue<Food> queue, String name) {
        this.queue = queue;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Food food = queue.take();
                System.out.println("\nПотребитель: " + this.name);
                System.out.println("\tВзял : " + food.getName());
                sumCalories += food.getCalories();
                System.out.println("\tСуммарно потребил " + sumCalories + " килокалорий");
            }
        } catch (InterruptedException e) {
            // System.out.println("Прерывание потока " + Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        }
    }
}
