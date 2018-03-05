package bugmakers.club.dp.creational.seq2.factorymethod.demooptimized.two;

import bugmakers.club.dp.creational.seq2.factorymethod.demo.Logger;

/**
 * @Description: 重载抽象工厂方法
 * @Author: Bruce
 * @Datetime: 2018/3/5 17:23
 */
public interface LoggerFactory {

    Logger createLogger();
    Logger createLogger(String arg);
    Logger createLogger(Object obj);
}
