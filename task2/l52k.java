package task2;


import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

class Save {
    long value = 0;

    Save(long value) {
        this.value = value;
    }
}

class MultiSum implements Runnable {
    private Save sum;
    private long fromInt;
    private long toInt;
    private long threadNo;
    private int x;
    static final CountDownLatch latch = new CountDownLatch(10);

    public MultiSum(Save sum, long fromInt, long toInt, long threadNo, int x) {
        this.sum = sum;
        this.fromInt = fromInt;
        this.toInt = toInt;
        this.threadNo = threadNo;
        this.x = x;

    }

    @Override
    public void run() {

        for (long i = fromInt; i <= toInt; i++) {
            if(contain(i,x)) {
                this.sum.value += i;
            }
        }

        latch.countDown();


    }


    public static void main(String[] args) throws InterruptedException {

        long ans = 1000000000; // 对从1到1,000,000,000进行加和
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        long Savesum = 0;
        int threads = 10; // 计算线程数
        // 每个线程计算一段连续的加和，并将加和结果保存在数组中。
        Save[] subSum = new Save[threads];
        for (int i = 0; i < threads; i++) {
            subSum[i] = new Save(0);
        }
        for (int i = 0; i < threads; i++) {
            long fromInt = ans * i / threads + 1; // 边界条件
            long toInt = ans * (i + 1) / threads; // 边界条件
            new Thread(new MultiSum(subSum[i], fromInt, toInt, i ,x)).start();

        }
        Thread.sleep(20);
        MultiSum.latch.await();
        for (int i = 0; i < threads; i++) {
            Savesum += subSum[i].value;
        }



        System.out.println("The sum is :" + Savesum);
    }
    private static boolean contain(long num, int x) {
        return String.valueOf(num).contains(String.valueOf(x));
    }
}

