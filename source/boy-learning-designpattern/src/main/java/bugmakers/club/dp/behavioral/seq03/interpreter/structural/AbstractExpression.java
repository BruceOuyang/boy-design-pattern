package bugmakers.club.dp.behavioral.seq03.interpreter.structural;

/**
 * @Description: 抽象表达式类
 * @Author: Bruce
 * @Datetime: 2018/3/20 14:45
 */
public abstract class AbstractExpression {

    /**
     * 解释操作
     * @param context
     */
    public abstract void interpert(InterpreterContext context);
}
