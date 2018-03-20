package bugmakers.club.dp.behavioral.seq03.interpreter.demooptimized;

/**
 * @Description: 语句命令节点类：非终结符表达式
 * @Author: Bruce
 * @Datetime: 2018/3/20 17:27
 */
public class CommandNode extends Node {

    private static final String LOOP = "LOOP";

    private Node node;

    @Override
    public void interpret(Context context) {

        // 处理LOOP循环命令
        if(LOOP.equals(context.currentToken())){
            node = new LoopCommandNode();
            node.interpret(context);
        }
        // 处理其他基本命令
        else{
            node = new PrimitiveCommandNode();
        }
        node.interpret(context);
    }

    @Override
    public void execute() {
        node.execute();
    }
}
