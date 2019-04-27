package com.roocon.single;

/**
 * @Author 贾
 * @Date 2019/3/823:06
 *
 * 懒汉式安全加载
 */
public class SingleTon {

    private static SingleTon singleTon = null;

    public static SingleTon getInstance(){
        //首先判空
        if(singleTon == null){
            //为空 进入 多线程有可能已进入 未执行以下代码 有一个线程进入
            synchronized (SingleTon.class){
                //在判空 生成
                if(singleTon == null) {
                    singleTon = new SingleTon();
                }
            }
        }
        return singleTon;
    }

}


