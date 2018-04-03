package bugmakers.club.dp.behavioral.seq10.templatemethod.demooptimized;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/4/3 11:26
 */
public class TemplatemethodDemooptimizedClient {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {
        DataViewer dataViewer = new XMLDataViewer();
        dataViewer.process();
    }
}
