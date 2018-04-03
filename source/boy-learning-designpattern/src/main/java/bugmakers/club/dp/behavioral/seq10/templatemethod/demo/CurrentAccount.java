package bugmakers.club.dp.behavioral.seq10.templatemethod.demo;

/**
 * @Description: 活期账户类，充当具体子类
 * @Author: Bruce
 * @Datetime: 2018/4/3 10:24
 */
public class CurrentAccount extends Account {

    /**
     * 覆盖父类的抽象基本方法
     */
    @Override
    public void calculateInterest() {

        System.out.println("按活期利率计算利息！");
    }
}
