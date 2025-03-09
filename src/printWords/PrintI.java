package printWords;


public class PrintI implements Runnable {

    private PrintHelperState printHelperState;

    public PrintI(PrintHelperState printHelperState) {
        this.printHelperState = printHelperState;
    }

    @Override
    public void run() {
        synchronized (printHelperState) {
            while(printHelperState.getNextTurn() != Turn.I) {
                try {
                    System.out.println(" Going to sleep in I thread");
                    printHelperState.wait();
                    System.out.println("Waking up I thread");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("I ");
            printHelperState.setNextTurn(Turn.AM);
            printHelperState.notifyAll();
            }
        }
    }
