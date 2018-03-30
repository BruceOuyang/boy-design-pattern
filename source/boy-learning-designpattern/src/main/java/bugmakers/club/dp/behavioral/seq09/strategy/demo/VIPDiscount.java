package bugmakers.club.dp.behavioral.seq09.strategy.demo;

/**
 * @Description: VIP会员票折扣类：具体策略类
 * @Author: Bruce
 * @Datetime: 2018/3/30 15:50
 */
public class VIPDiscount implements Discount {

    public double calculate(double price) {
        System.out.println("会员票(五折)：");
        System.out.println("记录积分");
        return price * 0.5;
    }
}
