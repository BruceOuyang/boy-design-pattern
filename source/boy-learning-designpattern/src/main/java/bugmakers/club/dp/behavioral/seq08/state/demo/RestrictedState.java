package bugmakers.club.dp.behavioral.seq08.state.demo;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/29 17:16
 */
public class RestrictedState extends AccountState {

    public RestrictedState(AccountState state) {
        this.account = state.account;
    }

    @Override
    public void deposit(double amount) {
        account.setBalance(account.getBalance() + amount);
        checkState();
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("帐号受限，取款失败");
    }

    @Override
    public void computeInterest() {
        System.out.println("计算利息！");
    }

    @Override
    public void checkState() {
        if(account.getBalance() > 0) {
            account.setState(new NormalState(this));
        }
        else if(account.getBalance() > -2000) {
            account.setState(new OverdraftState(this));
        }
    }
}
