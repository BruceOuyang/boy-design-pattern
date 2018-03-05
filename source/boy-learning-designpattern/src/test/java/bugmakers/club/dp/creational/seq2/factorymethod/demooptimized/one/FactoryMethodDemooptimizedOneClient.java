package bugmakers.club.dp.creational.seq2.factorymethod.demooptimized.one;

import bugmakers.club.dp.creational.seq2.factorymethod.demo.Logger;
import bugmakers.club.dp.creational.seq2.factorymethod.demo.LoggerFactory;

/**
 * @Description: 工厂方法Demo客户端类
 * @Author: Bruce
 * @Datetime: 2018/3/5 17:02
 */
public class FactoryMethodDemooptimizedOneClient {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {

        // 客户端不关心具体日志记录器，由配置文件配置
        LoggerFactory loggerFactory = (LoggerFactory) FactoryMethodXMLUtil.getBean();
        Logger logger = loggerFactory.createLogger();
        logger.writeLog();
    }
}
