package bugmakers.club.dp.review.soccerandpattern.creational.factorymethod;

/**
 * @Description: 工厂方法模式：近年来大型足球比赛（世界杯和欧洲杯）的指定用球都是阿迪达斯的（据说是签了合同的），
 *               当然Adidas足球是由Adidas公司生产的，除此之外，Nike公司也生产Nike足球，KAPPA（背靠背）公司也生产背靠背足球，
 *               足球生产商是工厂，足球是产品。增加一种新的足球品牌，对应需要增加一个新的生产商。
 * @Author: Bruce
 * @Datetime: 2018/4/11 17:43
 */
public class AbstractBallFactory {

    public static final String NIKE = "nike";
    public static final String KAPPA = "kappa";
    public static final String ADIDAS = "adidas";

    /**
     * 创建足球
     * @param brand
     * @return
     */
    public AbstractBall createBall(String brand) {
        AbstractBall ball = null;
        if(NIKE.equalsIgnoreCase(brand)){
            ball = new NikeBall();
        } else if(KAPPA.equalsIgnoreCase(brand)){
            ball = new KappaBall();
        } else if(ADIDAS.equalsIgnoreCase(brand)){
            ball = new AdidasBall();
        }
        return ball;
    }
}

