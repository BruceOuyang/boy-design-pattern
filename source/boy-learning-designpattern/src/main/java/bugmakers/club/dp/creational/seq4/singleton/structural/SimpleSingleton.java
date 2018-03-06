package bugmakers.club.dp.creational.seq4.singleton.structural;

/**
 * @Description: 简单单例模式，高并发下会出现多个实例，一般不用这种模式
 * @Author: Bruce
 * @Datetime: 2018/3/6 17:11
 */
public class SimpleSingleton {

    /**
     * 私有静态成员变量，存储唯一实例
     */
    private static SimpleSingleton instance = null;

    /**
     * 公有静态成员方法，返回唯一实例
     * @return
     */
    public static SimpleSingleton getLoadBalancer() {
        if (instance == null) {
            instance = new SimpleSingleton();
        }
        return instance;
    }
}
