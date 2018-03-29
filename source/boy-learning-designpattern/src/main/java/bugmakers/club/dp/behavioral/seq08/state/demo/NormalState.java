package bugmakers.club.dp.behavioral.seq08.state.demo;

/**
 * @Description: 正常状态：具体状态类
 * @Author: Bruce
 * @Datetime: 2018/3/29 16:51
 */
public class NormalState extends AccountState {

    public NormalState(Account account) {
        this.account = account;
    }

    public NormalState(AccountState state) {
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
        System.out.println("正常状态，无须支付利息！");
    }

    /**
     * 调整状态
     */
    @Override
    public void checkState() {
        if (account.getBalance() > -2000 && account.getBalance() <= 0) {
            account.setState(new OverdraftState(this));
        }
        else if (account.getBalance() == -2000) {
            account.setState(new RestrictedState(this));
        }
        else if (account.getBalance() < -2000) {
            System.out.println("操作受限！");
        }
    }
}
