package bugmakers.club.dp.behavioral.seq09.strategy.demo;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/30 15:46
 */
public class MovieTicket {

    /**
     * 电影票价格
     */
    private double price;

    /**
     * 维持一个对抽象折扣类的引用
     */
    private Discount discount;

    /**
     * 注入一个折扣类对象
     * @param discount
     */
    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public double getPrice() {
        // 调用折扣类的折扣价计算方法
        return discount.calculate(this.price);
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
