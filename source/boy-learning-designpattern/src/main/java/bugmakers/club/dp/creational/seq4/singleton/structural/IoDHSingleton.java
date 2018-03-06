package bugmakers.club.dp.creational.seq4.singleton.structural;

/**
 * @Description: 被称之为Initialization Demand Holder (IoDH)的技术，综合 EagerSingleton & LazySingleton 的优点
 * @Author: Bruce
 * @Datetime: 2018/3/6 17:21
 */
public class IoDHSingleton {

    private IoDHSingleton() {
    }

    /**
     * 内部类，系统初始化的时候，只会初始化HolderClass，不会初始化内部的IoDHSingleton
     */
    private static class HolderClass {
        private final static IoDHSingleton instance = new IoDHSingleton();
    }

    /**
     * 提供公共方法获取内部类的单例实例
     * @return
     */
    public static IoDHSingleton getInstance() {
        return HolderClass.instance;
    }

}
