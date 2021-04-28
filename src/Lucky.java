public class Lucky {
    public static final StateObject stateObject = new StateObject();

    static class LuckyThread extends Thread {
        @Override
        public void run() {
            synchronized (stateObject) {
                while (stateObject.getX() < 999999) {
                    stateObject.incX();
                    if ((stateObject.getX() % 10) + (stateObject.getX() / 10) % 10 + (stateObject.getX() / 100) % 10 ==
                            (stateObject.getX() / 1000)
                                    % 10 + (stateObject.getX() / 10000) % 10 + (stateObject.getX() / 100000) % 10) {
                        System.out.println(stateObject.getX());
                        stateObject.incCount();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new LuckyThread();
        Thread t2 = new LuckyThread();
        Thread t3 = new LuckyThread();
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println("Total: " + stateObject.getCount());
    }
}
