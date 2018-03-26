package bugmakers.club.dp.behavioral.seq05.mediator.structural;

/**
 * @Description: 具体中介者类
 * @Author: Bruce
 * @Datetime: 2018/3/26 11:19
 */
public class ConcreteMediator extends Mediator {

    /**
     * special biz code
     */
    // ..........

    /**
     * 实现业务方法，封装同事之间的调用
     */
    @Override
    public void operation() {

        // biz code

        // 通过中介者调用同事类的方法
        colleagues.get(0).medthod1();

        // biz code

    }
}
