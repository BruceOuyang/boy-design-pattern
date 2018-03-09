package bugmakers.club.dp.structural.seq2.bridge.demooptimized;

import bugmakers.club.dp.structural.seq2.bridge.demooptimized.datacollector.ExcelReportDataCollector;
import bugmakers.club.dp.structural.seq2.bridge.demooptimized.datacollector.ReportDataCollector;
import bugmakers.club.dp.structural.seq2.bridge.demooptimized.reportviewer.PdfReportViewer;
import bugmakers.club.dp.structural.seq2.bridge.demooptimized.reportviewer.ReportViewer;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/9 17:48
 */
public class BridgeDemooptimizedClient {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {
        ReportDataCollector collector = new ExcelReportDataCollector();

        ReportViewer viewer = new PdfReportViewer();
        viewer.setCollector(collector);

        viewer.displayReport();
    }
}
