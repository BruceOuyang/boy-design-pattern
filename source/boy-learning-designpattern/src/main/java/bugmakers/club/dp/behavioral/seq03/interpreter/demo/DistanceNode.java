package bugmakers.club.dp.behavioral.seq03.interpreter.demo;

/**
 * @Description: 距离解释：终结符表达式
 * @Author: Bruce
 * @Datetime: 2018/3/20 16:05
 */
public class DistanceNode extends AbstractNode {

    private String distance;

    public DistanceNode(String distance) {
        this.distance = distance;
    }

    /**
     * 距离表达式的解释操作
     * @return
     */
    @Override
    public String interpret() {
        return this.distance;
    }
}
