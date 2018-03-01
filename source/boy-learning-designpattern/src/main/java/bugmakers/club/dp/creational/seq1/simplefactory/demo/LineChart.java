package bugmakers.club.dp.creational.seq1.simplefactory.demo;

/**
 * @Description: 折线图类：具体产品类
 * @Author: Bruce
 * @Datetime: 2018/3/1 16:12
 */
public class LineChart implements Chart {

    public LineChart() {
        System.out.println("创建折线图！");
    }

    public void display() {
        System.out.println("显示折线图！");
    }
}
