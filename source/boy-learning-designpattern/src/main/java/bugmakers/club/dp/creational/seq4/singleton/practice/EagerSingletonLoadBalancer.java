package bugmakers.club.dp.creational.seq4.singleton.practice;

import bugmakers.club.dp.creational.seq4.singleton.demo.BaseLoadBalancer;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/6 17:42
 */
public class EagerSingletonLoadBalancer extends BaseLoadBalancer {

    private static EagerSingletonLoadBalancer eagerLoadBalancer = new EagerSingletonLoadBalancer();

    private EagerSingletonLoadBalancer(){}

    public static EagerSingletonLoadBalancer getEagerLoadBalance(){
        return eagerLoadBalancer;
    }
}
