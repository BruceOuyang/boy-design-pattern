package bugmakers.club.dp.behavioral.seq08.state.demo;

/**
 * @Description: 抽象状态类
 * @Author: Bruce
 * @Datetime: 2018/3/29 16:40
 */
public abstract class AccountState {

    /**
     * 账户
     */
    protected Account account;

    /**
     * 存款
     * @param amount
     */
    public abstract void deposit(double amount);

    /**
     * 取款
     * @param amount
     */
    public abstract void withdraw(double amount);

    /**
     * 计算利息
     */
    public abstract void computeInterest();

    /**
     * 检查状态
     */
    public abstract void checkState();
}
