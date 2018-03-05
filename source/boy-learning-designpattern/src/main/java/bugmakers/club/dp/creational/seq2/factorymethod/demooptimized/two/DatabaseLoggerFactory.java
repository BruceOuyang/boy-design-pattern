package bugmakers.club.dp.creational.seq2.factorymethod.demooptimized.two;

import bugmakers.club.dp.creational.seq2.factorymethod.demo.DatabaseLogger;
import bugmakers.club.dp.creational.seq2.factorymethod.demo.Logger;

/**
 * @Description: 重载工厂方法
 * @Author: Bruce
 * @Datetime: 2018/3/5 17:26
 */
public class DatabaseLoggerFactory implements LoggerFactory {

    /**
     * 默认实现
     * @return
     */
    public Logger createLogger() {

        //使用默认方式连接数据库，代码省略
        Logger logger = new DatabaseLogger();

        //初始化数据库日志记录器，代码省略

        return logger;
    }

    /**
     * 字符串参数：可能是数据库连接字符串
     * @param arg
     * @return
     */
    public Logger createLogger(String arg) {

        //使用参数args作为连接字符串来连接数据库，代码省略

        Logger logger = new DatabaseLogger();

        //初始化数据库日志记录器，代码省略

        return logger;
    }

    /**
     * 对象参数：可能是数据库连接各个关键属性的封装
     * @param obj
     * @return
     */
    public Logger createLogger(Object obj) {

        //使用封装在参数obj中的连接字符串来连接数据库，代码省略

        Logger logger = new DatabaseLogger();

        //使用封装在参数obj中的数据来初始化数据库日志记录器，代码省略

        return logger;
    }
}
