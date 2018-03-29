package bugmakers.club.dp.behavioral.seq08.state.demo;

/**
 * @Description: 透支状态：具体状态类
 * @Author: Bruce
 * @Datetime: 2018/3/29 17:10
 */
public class OverdraftState extends AccountState {

    public OverdraftState(AccountState state) {
        this.account = state.account;
    }

    @Override
    public void deposit(double amount) {
        account.setBalance(account.getBalance() + amount);
        checkState();
    }

    @Override
    public void withdraw(double amount) {
        account.setBalance(account.getBalance() - amount);
        checkState();
    }

    @Override
    public void computeInterest() {
        System.out.println("计算利息！");
    }

    @Override
    public void checkState() {
        if (account.getBalance() > 0) {
            account.setState(new NormalState(this));
        }
        else if (account.getBalance() == -2000) {
            account.setState(new RestrictedState(this));
        }
        else if (account.getBalance() < -2000) {
            System.out.println("操作受限！");
        }
    }
}
