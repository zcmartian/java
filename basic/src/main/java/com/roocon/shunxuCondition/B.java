package com.roocon.shunxuCondition;

import com.roocon.shunxudayin.Demo;

/**
 * @Author 贾
 * @Date 2019/3/1220:33
 */
class B implements Runnable{

    private Demo demo ;

    public B(Demo demo){
        this.demo = demo;
    }

    @Override
    public void run() {
        while (true) {
            demo.b();
        }
    }
}
