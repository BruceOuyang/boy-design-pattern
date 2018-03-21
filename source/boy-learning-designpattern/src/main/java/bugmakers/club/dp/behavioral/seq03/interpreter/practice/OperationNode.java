package bugmakers.club.dp.behavioral.seq03.interpreter.practice;

/**
 * @Description: 操作解释：终结符表达式
 * @Author: Bruce
 * @Datetime: 2018/3/21 17:14
 */
public class OperationNode extends AbstractPracticeNode {

    public static final String MOVE = "MOVE";
    public static final String COPY = "COPY";

    private AbstractPracticeNode node;

    /**
     * 解释操作命令
     * @param context
     */
    @Override
    public void interpret(PracticeContext context) {

        // MOVE指令
        if(MOVE.equalsIgnoreCase(context.currentToken())){
            node = new MoveNode();
        }
        // COPY指令
        else if(COPY.equalsIgnoreCase(context.currentToken())){
            node = new CopyNode();
        }
        // 其他指令
        else{
            node = new OtherNode();
        }
        node.interpret(context);
    }

    /**
     * 执行操作命令
     */
    @Override
    public void execute() {
        node.execute();
    }
}
