package printEvenOdd;

public class PrintEvenThread implements Runnable {

    private final EvenOddState evenOddState;

    public PrintEvenThread(EvenOddState evenOddState) {
        this.evenOddState = evenOddState;
    }

    @Override
    public void run() {
        synchronized (evenOddState) {
            while (evenOddState.getCurrent() < evenOddState.getEnd()) {
                while (evenOddState.getEvenOdd() != EvenOdd.EVEN) {
                    try {
                        evenOddState.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Even thread:" + "Thread id :" + Thread.currentThread().getName()+ "number" +  evenOddState.getCurrent());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                evenOddState.setCurrent(evenOddState.getCurrent() + 1);
                evenOddState.setEvenOdd(EvenOdd.ODD);
                evenOddState.notifyAll();
            }
        }
    }
}
