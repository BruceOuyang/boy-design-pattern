package bugmakers.club.dp.creational.seq1.simplefactory.demo;

import bugmakers.club.dp.creational.seq1.simplefactory.demooptimized.SimpleFactoryXMLUtil;

/**
 * @Description: 图表工厂类：工厂类
 * @Author: Bruce
 * @Datetime: 2018/3/1 16:13
 */
public class ChartFactory {

    /**
     * 柱状图
     */
    private static final String HISTOGRAM = "histogram";
    /**
     * 饼状图
     */
    private static final String PIE = "pie";
    /**
     * 折线图
     */
    private static final String LINE = "line";

    /**
     * 静态工厂方法
     * @param type
     * @return
     */
    public static Chart getChart(String type) {

        Chart chart = null;
        if (HISTOGRAM.equalsIgnoreCase(type)) {
            chart = new HistogramChart();
            System.out.println("初始化设置柱状图！");
        }
        else if (PIE.equalsIgnoreCase(type)) {
            chart = new PieChart();
            System.out.println("初始化设置饼状图！");
        }
        else if (LINE.equalsIgnoreCase(type)) {
            chart = new LineChart();
            System.out.println("初始化设置折线图！");
        }
        else {
            System.out.println("不支持的统计图类型");
        }
        return chart;
    }

    /**
     * 静态工厂方法
     * @return
     */
    public static Chart getChart() {
        //读取配置文件中的参数
        String type = SimpleFactoryXMLUtil.getChartType();
        return getChart(type);
    }
}
