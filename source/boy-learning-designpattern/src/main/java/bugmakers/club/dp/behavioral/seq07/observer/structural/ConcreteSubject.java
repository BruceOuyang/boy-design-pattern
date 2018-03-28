package bugmakers.club.dp.behavioral.seq07.observer.structural;

/**
 * @Description: 具体目标类
 * @Author: Bruce
 * @Datetime: 2018/3/28 11:26
 */
public class ConcreteSubject extends Subject {

    /**
     * 实现通知方法
     */
    @Override
    public void notifyObservers() {

        // 遍历观察者集合，调用每一个观察者的响应方法
        for(Object obj : list) {
            ((Observer) obj).update();
        }
    }
}
