package bugmakers.club.dp.creational.seq1.simplefactory.demo;

/**
 * @Description: 饼状图类：具体产品类
 * @Author: Bruce
 * @Datetime: 2018/3/1 16:12
 */
public class PieChart implements Chart {

    public PieChart() {
        System.out.println("创建饼状图！");
    }

    public void display() {
        System.out.println("显示饼状图！");
    }
}
