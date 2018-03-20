package bugmakers.club.dp.behavioral.seq03.interpreter.structural;

/**
 * @Description: 非终结符表达式
 * @Author: Bruce
 * @Datetime: 2018/3/20 15:41
 */
public class NonterminalExpression extends AbstractExpression {

    private AbstractExpression left;
    private AbstractExpression right;

    public NonterminalExpression(AbstractExpression left, AbstractExpression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * 解释操作
     * @param context
     */
    @Override
    public void interpert(InterpreterContext context) {

        //递归调用每一个组成部分的interpret()方法

        //在递归调用时指定组成部分的连接方式，即非终结符的功能

    }
}
