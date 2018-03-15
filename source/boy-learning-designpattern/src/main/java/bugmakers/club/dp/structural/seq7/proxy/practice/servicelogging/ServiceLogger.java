package bugmakers.club.dp.structural.seq7.proxy.practice.servicelogging;

import java.text.MessageFormat;
import java.util.Date;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/15 18:14
 */
public class ServiceLogger {

    public void log(String method){
        System.out.println(MessageFormat.format("方法{0}被调用，调用时间为{1}", method, new Date().toString()));
    }
}
