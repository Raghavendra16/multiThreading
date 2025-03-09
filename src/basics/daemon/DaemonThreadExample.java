package basics.daemon;

public class DaemonThreadExample {
    public static void main(String[] args) {
        Thread daemon = new Thread(new DaemonHelper());
        daemon.setDaemon(true);
        daemon.start();
        Thread user = new Thread(new UserHelper());
        user.start();
    }
}

class DaemonHelper implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            System.out.println("printing i in dameon helper = " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class UserHelper implements Runnable {

    @Override
    public void run() {
            try {
                System.out.println("in user thread");

                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        System.out.println("exiting user thread");
        }
    }