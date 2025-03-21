package printEvenOdd;

public class PrintOddThread implements Runnable {

    private final EvenOddState evenOddState;

    public PrintOddThread(EvenOddState evenOddState) {
        this.evenOddState = evenOddState;
    }

    @Override
    public void run() {
        synchronized (evenOddState) {
           //can move this check outside while loop
            while (evenOddState.getCurrent() < evenOddState.getEnd()) {
                while (evenOddState.getEvenOdd() != EvenOdd.ODD) {
                    try {
                        evenOddState.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Odd thread:" + "Thread id :" + Thread.currentThread().getName() + "number" + evenOddState.getCurrent());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                evenOddState.setCurrent(evenOddState.getCurrent() + 1);
                evenOddState.setEvenOdd(EvenOdd.EVEN);
                evenOddState.notifyAll();
            }
        }
    }
}
