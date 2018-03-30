package bugmakers.club.dp.behavioral.seq09.strategy.demo;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/30 16:05
 */
public class StrategyDemoClient {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {
        MovieTicket mt = new MovieTicket();
        double originalPrice = 60.0;
        double currentPrice;

        mt.setPrice(originalPrice);
        System.out.println("原始价为：" + originalPrice);
        System.out.println("---------------------------------");

        Discount discount;
        discount = (Discount)StrategyXMLUtil.getBean(); //读取配置文件并反射生成具体折扣对象
        mt.setDiscount(discount); //注入折扣对象

        currentPrice = mt.getPrice();
        System.out.println("折后价为：" + currentPrice);
    }
}
