package bugmakers.club.dp.behavioral.seq03.interpreter.practice;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/22 16:38
 */
public class InterpreterPracticeClient {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {
        PracticeContext copyContext = new PracticeContext("COPY VIEW FROM A TO B");
        PracticeContext moveContext = new PracticeContext("MOVE TABLE customer FROM A TO B");

        ExpressionNode copyNode = new ExpressionNode();
        copyNode.interpret(copyContext);
        System.out.println("");

        ExpressionNode moveNode = new ExpressionNode();
        moveNode.interpret(moveContext);
    }
}
