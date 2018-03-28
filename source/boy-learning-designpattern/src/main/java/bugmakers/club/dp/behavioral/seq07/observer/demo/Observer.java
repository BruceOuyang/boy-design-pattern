package bugmakers.club.dp.behavioral.seq07.observer.demo;

/**
 * @Description: 抽象观察类
 * @Author: Bruce
 * @Datetime: 2018/3/28 14:25
 */
public interface Observer {

    /**
     * 获取观察者名字
     * @return
     */
    String getName();

    /**
     * 设置观察者名字
     * @param name
     */
    void setName(String name);

    /**
     * 声明支援盟友方法
     */
    void help();

    /**
     * 声明遭受攻击方法
     * @param acc
     */
    void beAttacted(AllyControlCenter acc);

}
