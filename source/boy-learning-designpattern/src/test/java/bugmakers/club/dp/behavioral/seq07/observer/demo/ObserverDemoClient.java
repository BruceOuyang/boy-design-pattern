package bugmakers.club.dp.behavioral.seq07.observer.demo;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/28 15:11
 */
public class ObserverDemoClient {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {

        // 创建战队
        String allyName = "BuGMaker";
        AllyControlCenter acc = new ConcreteAllyControlCenter(allyName);

        // 创建盟友
        Observer angelia, andrea, amily, bruce, crystal;

        angelia = new Player("Angelia");
        acc.join(angelia);

        andrea = new Player("Andrea");
        acc.join(andrea);

        amily = new Player("Amily");
        acc.join(amily);

        bruce = new Player("Bruce");
        acc.join(bruce);

        crystal = new Player("Crystal");
        acc.join(crystal);

        // 模拟盟友被攻击
        crystal.beAttacted(acc);

        acc.quit(crystal);
    }
}
