package main.ru.sgu;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Cpp {
    
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
