package bugmakers.club.dp.behavioral.seq09.strategy.practice;

/**
 * @Description: 飞行器 - 抽象类
 * @Author: Bruce
 * @Datetime: 2018/4/2 10:06
 */
public abstract class AbstractAircraft {

    protected String name;

    /**
     * 起飞特征
     */
    protected String launchFeatures;

    /**
     * 飞行特征
     */
    protected String flyingFeatures;

    /**
     * 起飞
     */
    public void launch(){
        System.out.println("起飞特征：" + launchFeatures);
    }

    /**
     * 飞行
     */
    public void flying(){
        System.out.println("飞行特征：" + flyingFeatures);
    }
}
