package bugmakers.club.dp.creational.seq1.simplefactory.structural;

/**
 * @Description: 简单工厂客户端
 * @Author: Bruce
 * @Datetime: 2018/3/1 15:26
 */
public class Client {

    public static void main(String args[]) {
        AbstractProduct abstractProduct;

        //通过工厂类创建产品对象
        abstractProduct = SimpleFactory.getProduct("A");
        abstractProduct.methodSame();
        abstractProduct.methodDiff();
    }
}
