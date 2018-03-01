package bugmakers.club.dp.creational.seq1.simplefactory.demo;

/**
 * @Description: 图表工厂类：工厂类
 * @Author: Bruce
 * @Datetime: 2018/3/1 16:13
 */
public class ChartFactory {

    /**
     * 静态工厂方法
     * @param type
     * @return
     */
    public static Chart getChart(String type) {
        Chart chart = null;
        if (type.equalsIgnoreCase("histogram")) {
            chart = new HistogramChart();
            System.out.println("初始化设置柱状图！");
        }
        else if (type.equalsIgnoreCase("pie")) {
            chart = new PieChart();
            System.out.println("初始化设置饼状图！");
        }
        else if (type.equalsIgnoreCase("line")) {
            chart = new LineChart();
            System.out.println("初始化设置折线图！");
        }
        return chart;
    }
}
