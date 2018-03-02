package bugmakers.club.dp.creational.seq1.simplefactory.structural;

/**
 * @Description: 简单工厂类
 * @Author: Bruce
 * @Datetime: 2018/3/1 15:24
 */
public class SimpleFactory {

    /**
     * 静态工厂方法
     * @param arg
     * @return
     */
    public static AbstractProduct getProduct(String arg) {
        AbstractProduct abstractProduct = null;
        if (arg.equalsIgnoreCase("A")) {
            abstractProduct = new ConcreteAbstractProductA();
            //初始化设置product
        }
        else if (arg.equalsIgnoreCase("B")) {
            abstractProduct = new ConcreteAbstractProductB();
            //初始化设置product
        }
        return abstractProduct;
    }
}
