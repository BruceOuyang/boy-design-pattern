package bugmakers.club.dp.structural.seq2.bridge.demooptimized.datacollector;

/**
 * @Description: 文本数据采集器
 * @Author: Bruce
 * @Datetime: 2018/3/9 17:25
 */
public class TextReportDataCollector implements ReportDataCollector {

    public String collect() {
        String data = "text-value";
        System.out.println("从文本中读取数据");
        return data;
    }
}
