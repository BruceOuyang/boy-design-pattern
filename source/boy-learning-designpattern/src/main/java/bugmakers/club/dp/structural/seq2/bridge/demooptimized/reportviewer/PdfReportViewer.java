package bugmakers.club.dp.structural.seq2.bridge.demooptimized.reportviewer;

/**
 * @Description: pdf网页报表展示器
 * @Author: Bruce
 * @Datetime: 2018/3/9 17:46
 */
public class PdfReportViewer extends ReportViewer {

    @Override
    public void displayReport() {
        // 采集数据
        this.collector.collect();

        // 展示数据
        System.out.println("将数据显示在pdf上");
    }
}
