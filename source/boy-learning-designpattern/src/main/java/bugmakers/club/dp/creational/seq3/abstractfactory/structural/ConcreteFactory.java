package bugmakers.club.dp.creational.seq3.abstractfactory.structural;

/**
 * @Description: 具体工厂，具体工厂实现了抽象工厂，每一个具体的工厂方法可以返回一个特定的产品对象，而同一个具体工厂所创建的产品对象构成了一个产品族
 * @Author: Bruce
 * @Datetime: 2018/3/6 10:51
 */
public class ConcreteFactory extends AbstractFactory {

    @Override
    public ConcreteProductA concreteProductA() {
        return new ConcreteProductA();
    }

    @Override
    public ConcreteProductB concreteProductB() {
        return new ConcreteProductB();
    }
}
