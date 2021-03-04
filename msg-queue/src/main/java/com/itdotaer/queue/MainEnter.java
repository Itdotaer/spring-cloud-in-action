package com.itdotaer.queue;

/**
 * MainEnter
 *
 * @author jt_hu
 * @date 2021/3/2
 */
public class MainEnter {

    public static void main(String[] args) throws InterruptedException {
        CustomQueue<Integer> queue = new CustomQueue<>(100);

        for (int i = 0; i < 101; i++) {
            boolean rs = queue.offer(i);
            System.out.println("offer " + i + " " + rs);
        }

        CustomBlockingQueue<Integer> blockingQueue = new CustomBlockingQueue<>(10);

        new Thread(() -> {
            // 生产
            for (int i = 0; i < 10000; i++) {
                try {
                    blockingQueue.put(i);
                    System.out.println("put " + i);
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            // 消费
            while (true) {
                try {
                    Integer takeNum = blockingQueue.take();
                    System.out.println("take " + takeNum);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

}
