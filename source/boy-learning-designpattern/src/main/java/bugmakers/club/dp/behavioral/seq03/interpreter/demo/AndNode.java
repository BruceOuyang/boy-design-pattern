package bugmakers.club.dp.behavioral.seq03.interpreter.demo;

/**
 * @Description: And解释：非终结符表达式
 * @Author: Bruce
 * @Datetime: 2018/3/20 15:50
 */
public class AndNode extends AbstractNode {

    private AbstractNode left;
    private AbstractNode right;

    public AndNode(AbstractNode left, AbstractNode right) {
        this.left = left;
        this.right = right;
    }

    /**
     * And表达式的解释操作
     * @return
     */
    @Override
    public String interpret() {
        return left.interpret() + "再" + right.interpret();
    }
}
