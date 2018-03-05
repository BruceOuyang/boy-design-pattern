package bugmakers.club.dp.creational.seq2.factorymethod.demooptimized.three;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/5 17:34
 */
public class FactoryMethodDemooptimizedThreeClient {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {
        LoggerFactory loggerFactory = new DatabaseLoggerFactory();
        loggerFactory.writeLog();
    }
}
