package bugmakers.club.dp.review.soccerandpattern.creational.factorymethod;

public class AdidasBallFactory extends AbstractBallFactory {

    @Override
    public AbstractBall createBall() {
        return new AdidasBall();
    }
}
