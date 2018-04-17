package bugmakers.club.dp.review.soccerandpattern.creational.abstractfactory;

import bugmakers.club.dp.review.soccerandpattern.creational.abstractfactory.product.*;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/4/12 14:35
 */
public class NikeFactory extends AbstractFactory {

    @Override
    public Ball createBall() {
        return new NikeBall();
    }

    @Override
    public Uniform createUniform() {
        return new NikeUniform();
    }

    @Override
    public Shose createShose() {
        return new NikeShose();
    }
}

