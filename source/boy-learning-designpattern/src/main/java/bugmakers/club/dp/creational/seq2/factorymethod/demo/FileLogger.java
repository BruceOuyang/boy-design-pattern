package bugmakers.club.dp.creational.seq2.factorymethod.demo;

/**
 * @Description: 文件日志记录器：具体产品
 * @Author: Bruce
 * @Datetime: 2018/3/5 16:15
 */
public class FileLogger implements Logger {

    public void writeLog() {
        System.out.println("文件记录日志");
    }
}
