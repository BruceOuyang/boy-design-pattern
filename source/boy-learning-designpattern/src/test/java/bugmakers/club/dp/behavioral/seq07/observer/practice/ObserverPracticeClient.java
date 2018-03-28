package bugmakers.club.dp.behavioral.seq07.observer.practice;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/28 17:59
 */
public class ObserverPracticeClient {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {

        // 初始价格
        StockState initState = new StockState("BUGMaker", "BM", 1.0);

        // 创建交易所主题
        TradeSubject ts = new TradeConcreteSubject(initState);

        // 定义股民
        Investor angelia, amily, allen, bruce;

        angelia = new Investor("Angelia", new StockState("BUGMaker", "BM", 100.0));
        amily = new Investor("Amily", new StockState("BUGMaker", "BM", 200.0));
        allen = new Investor("Allen", new StockState("BUGMaker", "BM", 300.0));
        bruce = new Investor("Bruce", new StockState("BUGMaker", "BM", 400.0));

        ts.join(angelia);
        ts.join(amily);
        ts.join(allen);
        ts.join(bruce);

        // 定义机器人股民，用来做价格波动测试
        Investor robot = new Investor("Robot", initState);
        ts.join(robot);

        robot.updateNewPrice(326, ts);
    }
}
