package bugmakers.club.dp.creational.seq2.factorymethod.demo;

/**
 * @Description: 数据库日志记录器工厂类：具体工厂
 * @Author: Bruce
 * @Datetime: 2018/3/5 16:18
 */
public class DatabaseLoggerFactory implements LoggerFactory {

    public Logger createLogger() {

        // 连接数据库，代码略

        // 创建数据库日志记录器对象
        Logger logger = new DatabaseLogger();

        // 初始化数据库日志记录器，代码略

        return logger;
    }
}
