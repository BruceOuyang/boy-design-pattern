package bugmakers.club.dp.creational.seq2.factorymethod.demooptimized.two;


import bugmakers.club.dp.creational.seq2.factorymethod.demo.Logger;

/**
 * @Description: 工厂方法Demo客户端类
 * @Author: Bruce
 * @Datetime: 2018/3/5 17:02
 */
public class FactoryMethodDemooptimizedTwoClient {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {

        String DB_URL = "jdbc:....";

        LoggerFactory loggerFactory = new DatabaseLoggerFactory();
        Logger logger = loggerFactory.createLogger(DB_URL);
        logger.writeLog();
    }
}
