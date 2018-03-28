package bugmakers.club.dp.behavioral.seq07.observer.practice;

/**
 * @Description: 抽象观察者
 * @Author: Bruce
 * @Datetime: 2018/3/28 15:57
 */
public abstract class Observer {

    /**
     * 投资者姓名
     */
    private String name;

    /**
     * 购买股票的当前状态
     */
    private StockState stockState;

    public Observer(String name, StockState stockState) {
        this.name = name;
        this.stockState = stockState;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StockState getStockState() {
        return stockState;
    }

    public void setStockState(StockState stockState) {
        this.stockState = stockState;
    }

    /**
     * 设置一个新价格
     * @param newPrice
     * @param tcs
     */
    public void updateNewPrice(double newPrice, TradeSubject tcs){
        this.stockState.setPrice(newPrice);
        tcs.notifyInvestors(this.name, this.stockState);
    }

    /**
     * 抽象方法
     * @param stockState
     * @param range
     */
    public abstract void update(StockState stockState, String range);
}
