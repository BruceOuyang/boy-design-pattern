package bugmakers.club.dp.creational.seq1.simplefactory.practice;

/**
 * @Description: 不支持的形状异常
 * @Author: Bruce
 * @Datetime: 2018/3/2 11:06
 */
public class UnSupportedShapeException extends RuntimeException {

    public UnSupportedShapeException(String message) {
        super("不支持的形状：" + message);
    }
}
