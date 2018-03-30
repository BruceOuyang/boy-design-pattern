package bugmakers.club.dp.behavioral.seq09.strategy.demo;

/**
 * @Description: 儿童票折扣类：具体策略类
 * @Author: Bruce
 * @Datetime: 2018/3/30 15:50
 */
public class ChildrenDiscount implements Discount {

    public double calculate(double price) {
        System.out.println("学生票(优惠10元)：");
        return price - 10;
    }
}
