package xyz.tong2.leetcode.question;

public class No1115FooBar {
    private int n;
    volatile boolean lock = true;
    public No1115FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (this) {
                while (!lock) this.wait();
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                lock = ! lock;
                this.notify();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (this) {
                while (lock) this.wait();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                lock = ! lock;
                this.notify();
            }
        }
    }
}
