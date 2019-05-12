package com.mars.concurrency.third.chapter2;


@FunctionalInterface
public interface CalculatorStrategy {

    double calculate(double salary, double bonus);
}
