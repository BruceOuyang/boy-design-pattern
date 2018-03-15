package bugmakers.club.dp.structural.seq7.proxy.demo;

import java.text.MessageFormat;

/**
 * @Description: Logger：日志记录类，业务类，它提供方法Log()来保存日志
 * @Author: Bruce
 * @Datetime: 2018/3/15 17:07
 */
public class Logger {

    public void log(String userId){
        System.out.println(MessageFormat.format("更新数据库，用户{0}查询次数+1！",userId));
    }
}
