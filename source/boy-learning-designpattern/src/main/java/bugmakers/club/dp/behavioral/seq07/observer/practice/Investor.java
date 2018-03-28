package bugmakers.club.dp.behavioral.seq07.observer.practice;

import java.text.MessageFormat;

/**
 * @Description: 股票状态(股民购买的 & 股票即时的) ：具体观察者
 * @Author: Bruce
 * @Datetime: 2018/3/28 16:00
 */
public class Investor extends Observer {

    public Investor(String name, StockState stockState) {
        super(name, stockState);
    }

    @Override
    public void update(StockState newState, String range) {
        System.out.println(MessageFormat.format("Hi {0}，您购买的股票{1}-{2}的波动价格超过5%了。您的购买价格是：{3}，当前价格是：{4}，波动范围：{5}", this.getName(), newState.getName(), newState.getCode(), this.getStockState().getPrice(), newState.getPrice(), range));
    }
}
