package bugmakers.club.dp.behavioral.seq07.observer.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 交易中心：目标
 * @Author: Bruce
 * @Datetime: 2018/3/28 16:06
 */
public abstract class TradeSubject {

    /**
     * 股民列表
     */
    protected List<Investor> investorList = new ArrayList<Investor>();

    /**
     * 股票
     */
    protected StockState stockState;

    public StockState getStockState() {
        return stockState;
    }

    public void setStockState(StockState stockState) {
        this.stockState = stockState;
    }

    /**
     * 加入
     * @param investor
     */
    public void join(Investor investor) {
        investorList.add(investor);
    }

    /**
     * 退出
     * @param investor
     */
    public void quit(Investor investor) {
        investorList.remove(investor);
    }

    /**
     * 通知所有投资者
     * @param investor
     * @param stockState
     */
    public abstract void notifyInvestors(String investor, StockState stockState);
}