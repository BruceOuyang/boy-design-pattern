package bugmakers.club.dp.behavioral.seq03.interpreter.demooptimized;

/**
 * @Description: 基本命令节点类：终结符表达式
 * @Author: Bruce
 * @Datetime: 2018/3/20 17:34
 */
public class PrimitiveCommandNode extends Node {

    /**
     * PRINT
     */
    private static final String PRINT = "PRINT";

    /**
     * BREAK
     */
    private static final String BREAK = "BREAK";

    /**
     * SPACE
     */
    private static final String SPACE = "SPACE";

    private String name;
    private String text;

    /**
     * 解释基本命令
     * @param context
     */
    @Override
    public void interpret(Context context) {

        name = context.currentToken();
        context.skipToken(name);

        if(!PRINT.equals(name) && !BREAK.equals(name) && !SPACE.equals(name)){
            System.err.println("非法命令！");
        }
        if(PRINT.equals("PRINT")){
            text = context.currentToken();
            context.nextToken();
        }
    }

    @Override
    public void execute() {
        if(PRINT.equals(name)){
            System.out.print(text);
        }
        else if(SPACE.equals(name)){
            System.out.print(" ");
        }
        else if(BREAK.equals(name)){
            System.out.println();
        }
    }
}
