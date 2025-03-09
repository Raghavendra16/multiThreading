package printWords;

public class PrintAm implements Runnable {

    private PrintHelperState printHelperState;

    public PrintAm(PrintHelperState printHelperState) {
        this.printHelperState = printHelperState;
    }

    @Override
    public void run() {
        synchronized (printHelperState) {
            while (printHelperState.getNextTurn() != Turn.AM) {
                try {
                    System.out.println("Going to sleep in AM thread");
                    printHelperState.wait();
                    System.out.println("Waking up AM thread");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("AMMM ");
            printHelperState.setNextTurn(Turn.JAMESBOND);
            printHelperState.notifyAll();
        }
    }
}
