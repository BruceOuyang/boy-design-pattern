package bugmakers.club.dp.review.soccerandpattern.creational.abstractfactory;

import bugmakers.club.dp.review.soccerandpattern.creational.abstractfactory.product.*;

public class AdidasFactory extends AbstractFactory {

    @Override
    public Ball createBall() {
        return new AdidasBall();
    }

    @Override
    public Uniform createUniform() {
        return new AdidasUniform();
    }

    @Override
    public Shose createShose() {
        return new AdidasShose();
    }
}
