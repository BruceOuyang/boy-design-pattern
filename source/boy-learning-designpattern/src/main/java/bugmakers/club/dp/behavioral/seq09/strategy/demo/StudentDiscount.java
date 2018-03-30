package bugmakers.club.dp.behavioral.seq09.strategy.demo;

/**
 * @Description: 学生票折扣类：具体策略类
 * @Author: Bruce
 * @Datetime: 2018/3/30 15:48
 */
public class StudentDiscount implements Discount {

    public double calculate(double price) {
        System.out.println("学生票(八折)：");
        return price * 0.8;
    }
}
