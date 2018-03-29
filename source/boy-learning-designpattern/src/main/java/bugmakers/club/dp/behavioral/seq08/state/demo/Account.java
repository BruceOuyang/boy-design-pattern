package bugmakers.club.dp.behavioral.seq08.state.demo;

import java.text.MessageFormat;

/**
 * @Description: 银行账户：环境类
 * @Author: Bruce
 * @Datetime: 2018/3/29 16:39
 */
public class Account {

    /**
     * 维持一个对抽象状态对象的引用
     */
    private AccountState state;

    /**
     * 开户名
     */
    private String owner;

    /**
     * 账户余额
     */
    private double balance;

    public Account(String owner, double init) {
        this.owner = owner;
        this.balance = init;

        // 设置初始状态
        this.state = new NormalState(this);

        System.out.println(MessageFormat.format("用户{0}开户成功，初始金额为：{1}", this.owner, this.balance));
        System.out.println("------------------------------------");
    }

    public void setState(AccountState state) {
        this.state = state;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * 存钱
     * @param amount
     */
    public void deposit(double amount) {
        System.out.println(MessageFormat.format("{0}存款{1}", this.owner, amount));

        // 调用状态对象的deposit()方法
        state.deposit(amount);

        System.out.println("现金余额为：" + this.balance);

        System.out.println("现在帐户状态为："+ this.state.getClass().getName());
        System.out.println("---------------------------------------------");
    }

    /**
     * 取款
     * @param amount
     */
    public void withdraw(double amount) {
        System.out.println(MessageFormat.format("{0}取款{1}", this.owner, amount));

        //调用状态对象的withdraw()方法
        state.withdraw(amount);

        System.out.println("现在余额为：" + this.balance);
        System.out.println("现在帐户状态为：" + this. state.getClass().getName());
        System.out.println("---------------------------------------------");
    }

    /**
     * 计算利息
     */
    public void computeInterest() {
        this.state.computeInterest();
    }
}
