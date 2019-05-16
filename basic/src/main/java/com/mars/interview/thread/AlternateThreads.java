package com.mars.interview.thread;

public class AlternateThreads {
    public static void main(String[] args) {
        Res res = new Res();

        Thread letterThread = new Thread(new LetterRunner(res));
        Thread numberThread = new Thread(new NumberRunner(res));

        letterThread.start();
        numberThread.start();

    }
}

class Res {
    char letter = 'A';
    int number = 1;
    boolean isLetter = true;
}

class LetterRunner implements Runnable {
    Res res;

    public LetterRunner(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        while (res.letter <= 'Z') {
            synchronized (res) {
                if (!res.isLetter) {
                    try {
                        res.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.print(res.letter);
                    res.letter++;
                    res.isLetter = false;
                    res.notify();
                }
            }
        }
    }
}

class NumberRunner implements Runnable {
    Res res;

    public NumberRunner(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        while (res.number <= 26) {
            synchronized (res) {
                if (res.isLetter) {
                    try {
                        res.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.print(res.number + " ");
                    res.number++;
                    res.isLetter = true;
                    res.notify();
                }
            }
        }
    }
}
