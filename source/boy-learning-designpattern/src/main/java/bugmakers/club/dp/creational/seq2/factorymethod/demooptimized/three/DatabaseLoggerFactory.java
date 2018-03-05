package bugmakers.club.dp.creational.seq2.factorymethod.demooptimized.three;

import bugmakers.club.dp.creational.seq2.factorymethod.demo.DatabaseLogger;
import bugmakers.club.dp.creational.seq2.factorymethod.demo.Logger;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/5 17:33
 */
public class DatabaseLoggerFactory extends LoggerFactory {

    @Override
    public Logger createLogger() {
        return new DatabaseLogger();
    }
}
