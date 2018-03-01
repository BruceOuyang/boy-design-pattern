package bugmakers.club.dp.creational.seq1.simplefactory;

/**
 * @Description: 简单工厂类
 * @Author: Bruce
 * @Datetime: 2018/3/1 15:24
 */
public class Factory {

    /**
     * 静态工厂方法
     * @param arg
     * @return
     */
    public static Product getProduct(String arg) {
        Product product = null;
        if (arg.equalsIgnoreCase("A")) {
            product = new ConcreteProductA();
            //初始化设置product
        }
        else if (arg.equalsIgnoreCase("B")) {
            product = new ConcreteProductB();
            //初始化设置product
        }
        return product;
    }
}
