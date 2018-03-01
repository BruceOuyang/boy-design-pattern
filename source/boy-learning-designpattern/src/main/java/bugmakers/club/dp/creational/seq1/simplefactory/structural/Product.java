package bugmakers.club.dp.creational.seq1.simplefactory.structural;

/**
 * @Description: 抽象产品类
 * @Author: Bruce
 * @Datetime: 2018/3/1 15:20
 */
public abstract class Product {

    /**
     * 所有产品类的公共业务方法
     */
    public void methodSame() {
        // 公共方法的实现
        System.out.println("抽象产品的公共业务处理");
    }

    /**
     * 声明抽象业务方法
     */
    public abstract void methodDiff();
}
