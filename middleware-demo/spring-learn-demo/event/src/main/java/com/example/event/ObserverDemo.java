package com.example.event;

import java.util.Observable;
import java.util.Observer;

/**
 * @Description
 * @Date: 2020/9/13 18:29
 * @Create by external_ll@163.com
 **/
public class ObserverDemo {

    public static void main(String[] args) {

        // Observable 直接使用时 未收到事件的原因是 change 关闭，setChanged() 方法为projected ,只能对Observable 进行扩展
        EventObservable observable = new EventObservable();
        observable.addObserver(new EventObserver());
        observable.notifyObservers("hello world");
    }

    static class EventObservable extends Observable{
        /**
         * Marks this <tt>Observable</tt> object as having been changed; the
         * <tt>hasChanged</tt> method will now return <tt>true</tt>.
         */
        @Override
        protected synchronized void setChanged() {
            super.setChanged();
        }

        /**
         * If this object has changed, as indicated by the
         * <code>hasChanged</code> method, then notify all of its observers
         * and then call the <code>clearChanged</code> method to indicate
         * that this object has no longer changed.
         * <p>
         * Each observer has its <code>update</code> method called with two
         * arguments: this observable object and the <code>arg</code> argument.
         *
         * @param arg any object.
         * @see Observable#clearChanged()
         * @see Observable#hasChanged()
         * @see Observer#update(Observable, Object)
         */
        @Override
        public void notifyObservers(Object arg) {
            setChanged();
            super.notifyObservers(arg);
            clearChanged();
        }
    }

    static class EventObserver implements Observer {

        @Override
        public void update(Observable o, Object message) {
            System.out.println("收到事件："+ message);
        }
    }
}
