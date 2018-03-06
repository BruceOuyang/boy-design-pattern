package bugmakers.club.dp.creational.seq3.abstractfactory.structural;

/**
 * @Description: 抽象工厂，提供一个创建一系列相关或相互依赖对象的接口，而无须指定它们具体的类。
 * @Author: Bruce
 * @Datetime: 2018/3/6 10:45
 */
public abstract class AbstractFactory {

    /**
     * 工厂方法一
     * @return
     */
    public abstract ConcreteProductA concreteProductA();

    /**
     * 工厂方法二
     * @return
     */
    public abstract ConcreteProductB concreteProductB();
}
