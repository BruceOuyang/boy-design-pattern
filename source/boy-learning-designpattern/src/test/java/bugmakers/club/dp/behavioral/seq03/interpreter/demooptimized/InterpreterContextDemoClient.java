package bugmakers.club.dp.behavioral.seq03.interpreter.demooptimized;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/20 17:51
 */
public class InterpreterContextDemoClient {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {
        String text = "LOOP 2 PRINT 杨过 SPACE SPACE PRINT 小龙女 BREAK END PRINT 郭靖 SPACE SPACE PRINT 黄蓉";

        Context context = new Context(text);

        Node node = new ExpressionNode();
        node.interpret(context);
        node.execute();
    }
}
