package bugmakers.club.dp.creational.seq2.factorymethod.demo;

/**
 * @Description: 文件日志记录器工厂类：具体工厂
 * @Author: Bruce
 * @Datetime: 2018/3/5 16:20
 */
public class FileLoggerFactory implements LoggerFactory {

    public Logger createLogger() {

        // 创建文件日志记录器
        Logger logger = new FileLogger();

        // 创建文件，代码略

        return logger;
    }
}
