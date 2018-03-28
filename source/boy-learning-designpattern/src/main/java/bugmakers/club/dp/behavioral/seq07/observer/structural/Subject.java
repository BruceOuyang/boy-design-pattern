package bugmakers.club.dp.behavioral.seq07.observer.structural;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 抽象目标
 * @Author: Bruce
 * @Datetime: 2018/3/28 11:11
 */
public abstract class Subject {

    /**
     * 定义一个观察者集合用于存储所有观察者对象
     */
    protected List<Observer> list = new ArrayList<Observer>();

    /**
     * 注册方法，用于向观察者集合中增加一个观察者
     * @param observer
     */
    public void attach(Observer observer) {
        list.add(observer);
    }

    /**
     * 注销方法，用于在观察者集合中删除一个观察者
     * @param observer
     */
    public void detach(Observer observer) {
        list.remove(observer);
    }

    /**
     * 声明抽象通知方法
     */
    public abstract void notifyObservers();
}
