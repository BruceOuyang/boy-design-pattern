package bugmakers.club.dp.creational.seq4.singleton.demo;

/**
 * @Description: 负载均衡器LoadBalancer：单例类
 * @Author: Bruce
 * @Datetime: 2018/3/6 17:30
 */
public class SingletonLoadBalancer extends BaseLoadBalancer {

    /**
     * 私有静态成员变量，存储唯一实例
     */
    private static SingletonLoadBalancer instance = null;

    /**
     * 私有构造函数
     */
    private SingletonLoadBalancer() {}

    /**
     * 公有静态成员方法，返回唯一实例
     * @return
     */
    public static SingletonLoadBalancer getLoadBalancer() {
        if (instance == null) {
            instance = new SingletonLoadBalancer();
        }
        return instance;
    }
}
