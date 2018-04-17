package bugmakers.club.dp.review.soccerandpattern.creational.abstractfactory;

import bugmakers.club.dp.review.soccerandpattern.creational.abstractfactory.product.*;

public class KappaFactory extends AbstractFactory {

    @Override
    public Ball createBall() {
        return new KappaBall();
    }

    @Override
    public Uniform createUniform() {
        return new KappaUniform();
    }

    @Override
    public Shose createShose() {
        return new KappaShose();
    }
}
