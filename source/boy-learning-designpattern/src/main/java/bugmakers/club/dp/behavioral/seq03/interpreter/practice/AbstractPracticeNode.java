package bugmakers.club.dp.behavioral.seq03.interpreter.practice;

/**
 * @Description: 抽象节点类：抽象表达式
 * @Author: Bruce
 * @Datetime: 2018/3/21 17:13
 */
public abstract class AbstractPracticeNode {

    /**
     * 声明一个方法用于解释语句
     * @param context
     */
    public abstract void interpret(PracticeContext context);

    /**
     * 声明一个方法用于执行标记对应的命令
     */
    public abstract void execute();
}
