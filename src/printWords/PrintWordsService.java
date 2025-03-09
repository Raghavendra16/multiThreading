package printWords;

public class PrintWordsService {
    public static void main(String[] args) {
        PrintHelperState printHelperState = new PrintHelperState(Turn.I);
        new Thread(new PrintJamesBond(printHelperState)).start();
        new Thread(new PrintAm(printHelperState)).start();
        new Thread(new PrintI(printHelperState)).start();
    }
}
