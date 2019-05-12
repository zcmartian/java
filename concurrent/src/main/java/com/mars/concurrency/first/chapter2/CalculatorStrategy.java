package com.mars.concurrency.first.chapter2;


@FunctionalInterface
public interface CalculatorStrategy {

    double calculate(double salary, double bonus);
}
