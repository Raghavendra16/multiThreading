package printEvenOdd;



public class EvenOddState {
    private EvenOdd evenOdd;
    private final int start;
    private final int end;
    private int current;


    public EvenOddState(EvenOdd evenOdd, int start, int end) {
        this.evenOdd = evenOdd;
        this.start = start;
        this.current = start;
        this.end = end;
    }


    public EvenOdd getEvenOdd() {
        return evenOdd;
    }

    public void setEvenOdd(EvenOdd evenOdd) {
        this.evenOdd = evenOdd;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }
}
