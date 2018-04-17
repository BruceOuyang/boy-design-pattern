package bugmakers.club.dp.review.soccerandpattern.creational.factorymethod;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/4/12 14:11
 */
public class NikeBallFactory extends AbstractBallFactory {

    @Override
    public AbstractBall createBall() {
        return new NikeBall();
    }
}

