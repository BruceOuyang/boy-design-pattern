package bugmakers.club.dp.behavioral.seq03.interpreter.demo;

/**
 * @Description: 简单句子解释：非终结符表达式
 * @Author: Bruce
 * @Datetime: 2018/3/20 15:52
 */
public class SentenceNode extends AbstractNode {

    private AbstractNode direction;
    private AbstractNode action;
    private AbstractNode distance;

    public SentenceNode(AbstractNode direction, AbstractNode action, AbstractNode distance) {
        this.direction = direction;
        this.action = action;
        this.distance = distance;
    }

    /**
     * 简单句子的解释操作
     * @return
     */
    @Override
    public String interpret() {
        return direction.interpret() + action.interpret() + distance.interpret();
    }
}
