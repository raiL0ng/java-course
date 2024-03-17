package main.ru.sgu;

import java.util.Random;
import java.util.concurrent.BlockingQueue;


public class Producer implements Runnable {

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
