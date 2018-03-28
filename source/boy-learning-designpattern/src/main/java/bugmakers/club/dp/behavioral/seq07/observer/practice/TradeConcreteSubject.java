package bugmakers.club.dp.behavioral.seq07.observer.practice;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/28 16:51
 */
public class TradeConcreteSubject extends TradeSubject {

    /**
     * 构造函数注入股民购买该股票的当前状态
     * @param stockState
     */
    public TradeConcreteSubject(StockState stockState) {
        this.stockState = stockState;
    }

    @Override
    public void notifyInvestors(String investorName, StockState stockState) {

        for(Investor investor : investorList){

            // 判断是否为系统本身
            if(!investor.getName().equalsIgnoreCase(investorName)){

                // 判断价格波动是否超过5%
                double result = 0;
                String flag = "";
                double newPrice = stockState.getPrice();
                double oldPrice = investor.getStockState().getPrice();
                if(newPrice > oldPrice){
                    result = (newPrice - oldPrice)/oldPrice;
                }else{
                    flag = "-";
                    result = (oldPrice - newPrice)/oldPrice;
                }

                if(result > 0.05){
                    investor.update(stockState, flag + (result * 100) +"%");
                }
            }
        }
    }
}
