package com.roocon.blockQueue;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author 贾
 * @Date 2019/3/1717:08
 */
public class Tmall {

    private final Integer MAX_COUNT = 10 ;
    /**
     *
     * 阻塞队列的方法不一定是全部阻塞的
     *
     *  put/take ： 方法是阻塞的，每次取值/放值的时候，如果没有值/队列满的时候会阻塞
     *
     *  add/remove: 方法是不阻塞的，每次取值/放值的时候，如果没有值/队列满的时候会抛异常
     *
     *  offer/poll: 方法不是阻塞的，每次取值/放值的时候, 如果没有值/队列满的时候会返回true/false
     *
     */
    private BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

    public void push(Integer i){
        try {
            queue.put(i);
            System.out.println("添加成功，队列的长度："+queue.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void take(){
        try {
            queue.take();
            System.out.println("取出成功队列的长度："+queue.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
