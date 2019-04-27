package com.roocon.shunxuCondition;

import com.roocon.shunxudayin.Demo;

/**
 * @Author 贾
 * @Date 2019/3/1220:33
 */
class A implements Runnable{

    private Demo demo ;

    public A(Demo demo){
        this.demo = demo;
    }

    @Override
    public void run() {
        while (true) {
            demo.a();
        }
    }


}
