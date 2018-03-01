package bugmakers.club.dp.creational.seq1.simplefactory.demo;

/**
 * @Description: 简单工厂客户端实例客户端
 * @Author: Bruce
 * @Datetime: 2018/3/1 16:55
 */
public class SimpleFactoryDemoClient {

    public static void main(String args[]) {
        Chart chart;

        //通过静态工厂方法创建产品
        chart = ChartFactory.getChart("pie");
        chart.display();
    }
}
