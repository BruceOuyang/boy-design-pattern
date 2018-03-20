package bugmakers.club.dp.behavioral.seq03.interpreter.demo;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/20 16:27
 */
public class InterpreterDemoClient {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {
        String instruction = "up move 5 and down run 10 and left move 5";
        InstructionHandler handler = new InstructionHandler();
        handler.handle(instruction);
        System.out.println(handler.output());
    }
}
