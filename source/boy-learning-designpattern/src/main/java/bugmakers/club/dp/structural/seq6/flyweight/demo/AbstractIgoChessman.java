package bugmakers.club.dp.structural.seq6.flyweight.demo;

/**
 * @Description: 围棋棋子类：抽象享元类
 * @Author: Bruce
 * @Datetime: 2018/3/15 14:22
 */
public abstract class AbstractIgoChessman {

    public abstract String getColor();

    public void display() {
        System.out.println("棋子颜色：" + this.getColor());
    }
}
