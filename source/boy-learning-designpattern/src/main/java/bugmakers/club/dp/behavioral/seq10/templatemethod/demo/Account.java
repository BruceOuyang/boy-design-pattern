package bugmakers.club.dp.behavioral.seq10.templatemethod.demo;

import java.text.MessageFormat;

/**
 * @Description: 账户类，充当抽象类
 * @Author: Bruce
 * @Datetime: 2018/4/3 9:57
 */
public abstract class Account {

    public static final String USER_ACCOUNT = "bruce";
    public static final String USER_PWD = "124356";

    /**
     * 模拟登陆：基本方法——具体方法
     * @param account
     * @param password
     * @return
     */
    public boolean validate(String account, String password) {
        System.out.println(MessageFormat.format("账号：{0}\n密码：{1}", account, password));
        return (USER_ACCOUNT.equalsIgnoreCase(account) && USER_PWD.equals(password));
    }

    /**
     * 计算利息：基本方法——抽象方法
     */
    public abstract void calculateInterest();

    /**
     * 显示利息：基本方法——具体方法
     */
    public void display(){
        System.out.println("显示利息！");
    }

    /**
     * 模板方法
     * @param account
     * @param password
     */
    public void handle(String account, String password) {

        if(!validate(account, password)){
            System.out.println("账户或密码错误！");
            return;
        }

        calculateInterest();
        display();
    }
}
