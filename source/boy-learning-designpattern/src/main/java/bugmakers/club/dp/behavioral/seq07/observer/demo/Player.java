package bugmakers.club.dp.behavioral.seq07.observer.demo;

import java.text.MessageFormat;

/**
 * @Description: 战队成员类：具体观察者类
 * @Author: Bruce
 * @Datetime: 2018/3/28 14:47
 */
public class Player implements Observer {

    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 支援盟友方法的实现
     */
    public void help() {
        System.out.println(MessageFormat.format("坚持住，{0}来救你！", this.name));
    }

    /**
     * 遭受攻击方法的实现，当遭受攻击时将调用战队控制中心类的通知方法notifyObserver()来通知盟友
     * @param acc
     */
    public void beAttacted(AllyControlCenter acc) {
        System.out.println();
        System.out.println(MessageFormat.format("{0}被攻击", this.name));
        acc.notifyObserver(this.name);
    }
}
