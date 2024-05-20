public class PrintDemo {
    private volatile int flag = 1;

    class Thread1 implements Runnable {
        @Override
        public void run() {
            while (true) {
                if (flag == 1) {
                    System.out.println(1);
                    flag = 2;
                }
            }
        }
    }

    class Thread2 implements Runnable {
        @Override
        public void run() {
            while (true) {
                if (flag == 2) {
                    System.out.println(2);
                    flag = 3;
                }
            }
        }
    }

    class Thread3 implements Runnable {
        @Override
        public void run() {
            while (true) {
                if (flag == 3) {
                    System.out.println(3);
                    flag = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        PrintDemo print123 = new PrintDemo();
        new Thread(print123.new Thread1()).start();
        new Thread(print123.new Thread2()).start();
        new Thread(print123.new Thread3()).start();
    }

}
