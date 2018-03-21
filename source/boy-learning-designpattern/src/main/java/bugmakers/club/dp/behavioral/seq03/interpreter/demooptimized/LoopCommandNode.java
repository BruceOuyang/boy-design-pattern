package bugmakers.club.dp.behavioral.seq03.interpreter.demooptimized;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/20 17:34
 */
public class LoopCommandNode extends AbstractNode {

    private static final String LOOP = "LOOP";

    /**
     * 循环次数
     */
    private int number;

    /**
     * 循环语句中的表达式
     */
    private AbstractNode commandNode;

    /**
     * 解释循环命令
     * @param context
     */
    @Override
    public void interpret(Context context) {
        context.skipToken(LOOP);
        number = context.currentNumber();
        context.nextToken();

        // 循环语句中的表达式
        commandNode = new ExpressionNode();
        commandNode.interpret(context);
    }

    @Override
    public void execute() {
        for (int i = 0; i < number; i++) {
            commandNode.execute();
        }
    }
}
