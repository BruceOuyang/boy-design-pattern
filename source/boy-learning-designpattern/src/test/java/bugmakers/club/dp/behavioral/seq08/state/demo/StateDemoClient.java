package bugmakers.club.dp.behavioral.seq08.state.demo;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/29 17:22
 */
public class StateDemoClient {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {
        Account bruce = new Account("Bruce", 0.0);
        bruce.deposit(1000);
        bruce.withdraw(2000);
        bruce.deposit(3000);
        bruce.withdraw(4000);
        bruce.withdraw(1000);
        bruce.computeInterest();
    }
}
