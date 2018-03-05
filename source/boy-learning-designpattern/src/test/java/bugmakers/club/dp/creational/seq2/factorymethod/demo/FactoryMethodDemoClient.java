package bugmakers.club.dp.creational.seq2.factorymethod.demo;

/**
 * @Description: 工厂方法Demo客户端类
 * @Author: Bruce
 * @Datetime: 2018/3/5 16:34
 */
public class FactoryMethodDemoClient {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {

        // 客户端指定日志记录器
        LoggerFactory loggerFactory = new DatabaseLoggerFactory();

        Logger logger = loggerFactory.createLogger();

        logger.writeLog();
    }
}
