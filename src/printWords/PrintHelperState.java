package printWords;

public class PrintHelperState {

    private Turn nextTurn;

    public Turn getNextTurn() {
        return nextTurn;
    }

    public void setNextTurn(Turn nextTurn) {
        this.nextTurn = nextTurn;
    }

    public PrintHelperState(Turn nextTurn) {
        this.nextTurn = nextTurn;
    }
}
