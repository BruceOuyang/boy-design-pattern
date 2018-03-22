package bugmakers.club.dp.behavioral.seq03.interpreter.practice;

/**
 * @Description: 抽象节点类：抽象表达式
 * @Author: Bruce
 * @Datetime: 2018/3/21 17:13
 */
public abstract class AbstractPracticeNode {

    /**
     * 解释语句
     * @param context
     * @throws ErrExpressionException
     */
    public abstract void interpret(PracticeContext context) throws ErrExpressionException;

    /**
     * 执行命令
     */
    public abstract void execute();
}
