package main.ru.sgu;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Cpp {
    private class Food {
        private String name;
        private int calories;

        public Food(String n, int c) {
            this.name = n;
            this.calories = c;
        }

        public String getName() {
            return this.name;
        }

        public int getCalories() {
            return this.calories;
        }
    }

    private class Consumer implements Runnable {
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

    private class Producer implements Runnable {
        private BlockingQueue<Food> queue;
        private String name;


        public Producer(BlockingQueue<Food> q, String n) {
            this.queue = q;
            this.name = n;
        }


        @Override
        public void run() {
            try {  
                while (true) {
                    Random rand = new Random();
                    int randIndx = rand.nextInt(6);
                    Thread.sleep((randIndx + 1) * 500);
                    Food f;
                    switch (randIndx) {
                        case 0:
                            f = new Food("Борщ", 350); 
                            queue.put(f);
                            System.out.printf("%n%s добавила %s%n", this.name, f.name);
                            break;
                        case 1:
                            f = new Food("Суп грибной", 300);
                            queue.put(f);
                            System.out.printf("%n%s добавила %s%n", this.name, f.name);
                        case 2:
                            f = new Food("Окрошка", 290);
                            queue.put(f);
                            System.out.printf("%n%s добавила %s%n", this.name, f.name);
                            break;
                        case 3:
                            f = new Food("Котлетка с пюрешкой", 280);
                            queue.put(f);
                            System.out.printf("%n%s добавила %s%n", this.name, f.name);
                        case 4:
                            f = new Food("Макарошки с мясом", 200);
                            queue.put(f);
                            System.out.printf("%n%s добавила %s%n", this.name, f.name);
                            break;
                        case 5:
                            f = new Food("Салат оливье", 150);
                            queue.put(f);
                            System.out.printf("%n%s добавила %s%n", this.name, f.name);
                            break;
                        case 6:
                            f = new Food("Жюльен с курицей и грибами", 130);
                            queue.put(f);
                            System.out.printf("%n%s добавила %s%n", this.name, f.name);
                            break;
                        case 7:
                            f = new Food("Булочка с сосиской", 230);
                            queue.put(f);
                            System.out.printf("%n%s добавила %s%n", this.name, f.name);
                            break;
                        case 8:
                            f = new Food("Компот", 50);
                            queue.put(f);
                            System.out.printf("%n%s добавила %s%n", this.name, f.name);
                            break;
                    }                        
                }
            } catch (InterruptedException e) {
                // System.out.println("Прерывание потока " + Thread.currentThread().getName());
                Thread.currentThread().interrupt();
            }
        }
    }

    private int producersNums, consumersNums, delay;

    
    public Cpp(int pn, int cn, int d) {
        this.producersNums = pn;
        this.consumersNums = cn;
        this.delay = d;
    }


    public boolean checkValues() {
        return this.producersNums > 0 && this.consumersNums > 0 && this.delay > 0;
    }


    public void run() {
        BlockingQueue<Food> queue = new ArrayBlockingQueue<>(10);
        ArrayList<Thread> prod = new ArrayList<>(), cons = new ArrayList<>();
        for (int i = 0; i < this.producersNums; i++) {
            prod.add(new Thread(new Producer(queue, ("Повариха-" + i))));
        }

        for (int i = 0; i < this.consumersNums; i++) {
            cons.add(new Thread(new Consumer(queue, ("Школьник-" + i))));
        }

        ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(1);
        executor.schedule(() -> {
            prod.forEach(Thread::interrupt);
            cons.forEach(Thread::interrupt);
            executor.shutdownNow();
        }, this.delay, TimeUnit.SECONDS);

        for (Thread t : prod) {
            t.start();
        }

        for (Thread t : cons) {
            t.start();
        }
        executor.close();;
        System.out.println("Завершение работы (закрытие потоков)\n");
    }
}
