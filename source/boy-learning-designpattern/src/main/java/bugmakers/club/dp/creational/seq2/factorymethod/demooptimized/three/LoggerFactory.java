package bugmakers.club.dp.creational.seq2.factorymethod.demooptimized.three;

import bugmakers.club.dp.creational.seq2.factorymethod.demo.Logger;

/**
 * @Description: 对客户端隐藏工厂方法
 * @Author: Bruce
 * @Datetime: 2018/3/5 17:30
 */
public abstract class LoggerFactory {

    public void writeLog(){
        Logger logger = this.createLogger();
        logger.writeLog();
    }

    public abstract Logger createLogger();
}
