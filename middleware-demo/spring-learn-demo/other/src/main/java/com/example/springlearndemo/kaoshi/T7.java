package com.example.springlearndemo.kaoshi;

class Ticket implements Runnable{
    private static int ticket=10;
    @Override
    public void run() {
        for(int i=1;i<=100;i++){
            System.out.println(Thread.currentThread().getName()+" - 开始买票");

            synchronized(this){ //同步代码块+对象锁
                System.out.println(Thread.currentThread().getName()+" - 买了第"+ticket+"张票");
                ticket--;
            }

            System.out.println(Thread.currentThread().getName()+" - 结束买票");

            if(ticket<=0){break;}
        }
    }
}
public class T7 {
    public static void main(String[] args) {
        Ticket ticket=new Ticket();
        new Thread(ticket,"1号窗口").start();
        new Thread(ticket,"2号窗口").start();
        new Thread(ticket,"3号窗口").start();
    }
}
