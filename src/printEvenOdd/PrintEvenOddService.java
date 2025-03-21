package printEvenOdd;

public class PrintEvenOddService {

    public static void main(String[] args) {
        EvenOddState evenOddState = new EvenOddState(EvenOdd.EVEN,0,10);
        Thread t1 = new Thread(new PrintOddThread(evenOddState));
        Thread t2 = new Thread(new PrintEvenThread(evenOddState));
        t1.start();
        t2.start();
    }
}
