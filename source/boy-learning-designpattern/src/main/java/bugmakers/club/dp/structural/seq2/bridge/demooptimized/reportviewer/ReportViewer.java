package bugmakers.club.dp.structural.seq2.bridge.demooptimized.reportviewer;

import bugmakers.club.dp.structural.seq2.bridge.demooptimized.datacollector.ReportDataCollector;

/**
 * @Description: 报表展示器
 * @Author: Bruce
 * @Datetime: 2018/3/9 17:40
 */
public abstract class ReportViewer {

    protected ReportDataCollector collector;

    public void setCollector(ReportDataCollector collector) {
        this.collector = collector;
    }

    /**
     * 展示报表
     */
    public abstract void displayReport();
}
