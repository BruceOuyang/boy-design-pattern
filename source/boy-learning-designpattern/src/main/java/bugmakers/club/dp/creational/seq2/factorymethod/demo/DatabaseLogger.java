package bugmakers.club.dp.creational.seq2.factorymethod.demo;

/**
 * @Description: 数据库日志记录器：具体产品
 * @Author: Bruce
 * @Datetime: 2018/3/5 16:14
 */
public class DatabaseLogger implements Logger {

    public void writeLog() {
        System.out.println("数据库记录日志");
    }
}
