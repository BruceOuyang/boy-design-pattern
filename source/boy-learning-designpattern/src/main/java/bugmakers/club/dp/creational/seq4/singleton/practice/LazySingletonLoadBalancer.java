package bugmakers.club.dp.creational.seq4.singleton.practice;

import bugmakers.club.dp.creational.seq4.singleton.demo.BaseLoadBalancer;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/6 17:42
 */
public class LazySingletonLoadBalancer extends BaseLoadBalancer {

    private static LazySingletonLoadBalancer lazyLoadBalancer = null;

    private LazySingletonLoadBalancer(){}

    public static LazySingletonLoadBalancer getLazyLoadBalancer(){

        if(lazyLoadBalancer == null) {
            synchronized (LazySingletonLoadBalancer.class) {

                if(lazyLoadBalancer == null) {
                    lazyLoadBalancer = new LazySingletonLoadBalancer();
                }
            }
        }
        return lazyLoadBalancer;
    }
}
