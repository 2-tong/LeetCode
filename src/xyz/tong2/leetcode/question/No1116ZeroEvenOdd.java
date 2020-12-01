package xyz.tong2.leetcode.question;

import xyz.tong2.leetcode.util.IntConsumer;

public class No1116ZeroEvenOdd {
    private int n;
    private volatile int state;
    public No1116ZeroEvenOdd(int n) {
        this.n = n;
        state=0;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i=0;i<n;i++){
            synchronized (this){
                while (state!=0) this.wait();
                printNumber.accept(0);
                state = i%2+1;
                this.notifyAll();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i=2;i<=n;i+=2){
            synchronized (this){
                while (state!=2) this.wait();
                printNumber.accept(i);
                state=0;
                this.notifyAll();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i=1;i<=n;i+=2){
            synchronized (this){
                while (state!=1) this.wait();
                printNumber.accept(i);
                state=0;
                this.notifyAll();
            }
        }
    }
}
