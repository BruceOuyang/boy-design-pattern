package bugmakers.club.dp.creational.seq1.simplefactory.demo;

/**
 * @Description: 柱状图类：具体产品类
 * @Author: Bruce
 * @Datetime: 2018/3/1 16:10
 */
public class HistogramChart implements Chart {

    public HistogramChart() {
        System.out.println("创建柱状图！");
    }

    public void display() {
        System.out.println("显示柱状图！");
    }
}
