package bugmakers.club.dp.behavioral.seq05.mediator.structural;

/**
 * @Description: 具体同事类
 * @Author: Bruce
 * @Datetime: 2018/3/26 11:24
 */
public class ConcreteColleague extends Colleague {

    public ConcreteColleague(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void medthod1() {
        // biz
    }
}
