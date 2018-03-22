package bugmakers.club.dp.behavioral.seq03.interpreter.practice;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/22 16:14
 */
public class ErrExpressionException extends Exception {

    public ErrExpressionException(PracticeContext message) {
        super("错误的表达式：" + message.getText());
    }

    public ErrExpressionException(PracticeContext message, String remark) {
        super("错误的表达式：" + message.getText() + ", remark: " + remark);
    }
}
