package bugmakers.club.dp.behavioral.seq09.strategy.structural;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/30 15:04
 */
public class Context {

    /**
     * 维持一个对抽象策略类的引用
     */
    private AbstractStrategy strategy;

    public void setStrategy(AbstractStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 调用策略类中的算法
     */
    public void algorithm(){
        this.strategy.algorithm();
    }
}
