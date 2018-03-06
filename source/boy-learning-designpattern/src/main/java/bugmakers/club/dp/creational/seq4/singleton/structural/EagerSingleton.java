package bugmakers.club.dp.creational.seq4.singleton.structural;

/**
 * @Description: 饿汉单例模式 ： 在系统启动时就实例化掉一个静态实例，会导致系统启动慢，长久占用系统资源，影响系统性能，优点是无并发问题
 * @Author: Bruce
 * @Datetime: 2018/3/6 17:14
 */
public class EagerSingleton {

    /**
     * 静态成员变量，系统启动时执行实例化
     */
    private static final EagerSingleton instance = new EagerSingleton();

    /**
     * 默认构造方法的访问修饰符设为private，屏蔽外部通过new来实例化对象
     */
    private EagerSingleton() { }

    /**
     * 提供静态public方法来获取实例
     * @return
     */
    public static EagerSingleton getInstance() {
        return instance;
    }
}
