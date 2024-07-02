package test;

/**
 * JD 四面 ： 模拟死锁
 * 下面程序不sleep，如何控制？
 */
public class JD_4_DeadLock {

    private static final  Object  resourceA = new Object();
    private static final  Object  resourceB = new Object();
    public static void main(String[] args){

        Thread thread1 = new Thread(()->{
            synchronized (resourceA){
                System.out.println("Thread1: had resourceA..");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread1 wait resourceB..");
                synchronized (resourceB){
                    System.out.println("Thread1: had resourceB and resourceA..");
                }
            }
        });

        Thread thread2 = new Thread(()->{
            synchronized (resourceB){
                System.out.println("Thread2: had resourceB..");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread2 wait resourceA..");
                synchronized (resourceA){
                    System.out.println("Thread2: had resourceA and resourceB..");
                }
            }
        });



    }

}
