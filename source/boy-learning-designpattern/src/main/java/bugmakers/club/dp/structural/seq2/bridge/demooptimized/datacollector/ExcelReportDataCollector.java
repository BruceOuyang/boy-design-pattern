package bugmakers.club.dp.structural.seq2.bridge.demooptimized.datacollector;

import bugmakers.club.dp.structural.seq2.bridge.demooptimized.datacollector.adapter.CollectExcelDataReq;
import bugmakers.club.dp.structural.seq2.bridge.demooptimized.datacollector.adapter.ExcelDataCollectorAdapter;

/**
 * @Description: Excel表格数据采集器
 * @Author: Bruce
 * @Datetime: 2018/3/9 17:27
 */
public class ExcelReportDataCollector implements ReportDataCollector {
    public String collect() {

        CollectExcelDataReq req = new ExcelDataCollectorAdapter();
        return req.collectDataFromExcel();
    }
}
