package printWords;

public class PrintJamesBond implements Runnable{

    public PrintJamesBond(PrintHelperState printHelperState) {
        this.printHelperState = printHelperState;
    }

    private final PrintHelperState printHelperState;
    @Override
    public void run() {
        synchronized (printHelperState) {
            while (printHelperState.getNextTurn() !=Turn.JAMESBOND) {
                try {
                    System.out.println("going to sleep in james bond thread");
                    printHelperState.wait();
                    System.out.println("waking up james bond thread");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("JAMESS BOND.");
            printHelperState.setNextTurn(null);
        }
    }
}
