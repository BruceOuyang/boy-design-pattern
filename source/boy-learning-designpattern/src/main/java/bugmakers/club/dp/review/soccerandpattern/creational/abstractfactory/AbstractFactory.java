package bugmakers.club.dp.review.soccerandpattern.creational.abstractfactory;

import bugmakers.club.dp.review.soccerandpattern.creational.abstractfactory.product.Ball;
import bugmakers.club.dp.review.soccerandpattern.creational.abstractfactory.product.Shose;
import bugmakers.club.dp.review.soccerandpattern.creational.abstractfactory.product.Uniform;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/4/12 14:22
 */
public abstract class AbstractFactory {

    public abstract Ball createBall();
    public abstract Uniform createUniform();
    public abstract Shose createShose();
}
