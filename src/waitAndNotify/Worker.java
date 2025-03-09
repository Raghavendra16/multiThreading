package waitAndNotify;

import java.util.ArrayList;
import java.util.List;

public class Worker {

    private List<Integer> container;
    private int top;
    private int bottom;
    private int sequence = 0;
    private final Object lock = new Object();

    public Worker(int top, int bottom) {
        this.container = new ArrayList<>();
        this.top = top;
        this.bottom = bottom;
    }

    public void produce() throws InterruptedException {// block synchronization
        synchronized(lock) {
            while(true) {
                if(container.size() == top) {
                    System.out.println("Container full.. can be consumed.. going to waiting");
                    lock.wait();
                } else {
                        System.out.println("Producing sequence" + sequence++);
                        container.add(sequence);
                        lock.notify();
                    }
                Thread.sleep(2000);
                }
            }
        }

    public void consume() throws InterruptedException {
        synchronized (lock) {
            while (true) {
                if(container.size() == bottom) {
                    System.out.println("Container empty.. can be producer..consumer going to waiting");
                    lock.wait();
                }
                else {
                    System.out.println("Consuming sequence" + container.removeFirst());
                    lock.notify();
                }
                Thread.sleep(2000);
            }

        }
    }
}
