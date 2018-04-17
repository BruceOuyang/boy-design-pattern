package bugmakers.club.dp.review.soccerandpattern.creational.factorymethod;

public class KappaBallFactory extends AbstractBallFactory {

    @Override
    public AbstractBall createBall() {
        return new KappaBall();
    }
}
