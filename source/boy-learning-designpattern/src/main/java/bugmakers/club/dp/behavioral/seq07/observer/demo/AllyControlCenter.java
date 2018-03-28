package bugmakers.club.dp.behavioral.seq07.observer.demo;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 战队控制中心类：目标类
 * @Author: Bruce
 * @Datetime: 2018/3/28 14:27
 */
public abstract class AllyControlCenter {

    /**
     * 战队名称
     */
    protected String allyName;

    /**
     * 定义一个集合用于存储战队成员
     */
    protected List<Observer> players = new ArrayList<Observer>();

    public String getAllyName() {
        return allyName;
    }

    public void setAllyName(String allyName) {
        this.allyName = allyName;
    }

    /**
     * 注册方法
     * @param player
     */
    public void join(Observer player){
        System.out.println(MessageFormat.format("{0}加入{1}战队", player.getName(), this.allyName));
        players.add(player);
    }

    /**
     * 注销方法
     * @param player
     */
    public void quit(Observer player){
        System.out.println();
        System.out.println(MessageFormat.format("{0}退出{1}战队", player.getName(), this.allyName));
        players.remove(player);
    }

    /**
     * 声明抽象通知方法
     */
    public abstract void notifyObserver(String name);
}
