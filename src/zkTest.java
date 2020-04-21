import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class zkTest implements Runnable {
    static int inventory = 1;
    private static final int NUM = 10;
    private static CountDownLatch cdl = new CountDownLatch(NUM);
    private Lock lock;

    public zkTest(Lock lock){
        this.lock = lock;
    }
    public static void main (String[] args) {
        Lock lock = new ReentrantLock();
        for(int i = 0; i < NUM; i++){
            new Thread(new zkTest(lock)).start();
            cdl.countDown();
        }
    }

    @Override
    public void run() {
        lock.lock();
            try{
                cdl.await();
                if(inventory > 0){
                    Thread.sleep(5);
                    inventory--;
                    System.out.println(Thread.currentThread().getName());
                }
                System.out.println(inventory+"Thread:"+Thread.currentThread().getName());
            }catch (InterruptedException e){
                e.printStackTrace();;
            }
            finally {
                lock.unlock();
        }
    }
}
