package bugmakers.club.dp.behavioral.seq03.interpreter.demooptimized;

/**
 * @Description: 抽象节点类：抽象表达式
 * @Author: Bruce
 * @Datetime: 2018/3/20 17:18
 */
public abstract class AbstractNode {

    /**
     * 声明一个方法用于解释语句
     * @param context
     */
    public abstract void interpret(Context context);

    /**
     * 声明一个方法用于执行标记对应的命令
     */
    public abstract void execute();
}
