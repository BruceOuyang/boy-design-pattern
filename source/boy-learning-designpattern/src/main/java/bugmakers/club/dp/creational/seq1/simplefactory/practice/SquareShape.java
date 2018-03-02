package bugmakers.club.dp.creational.seq1.simplefactory.practice;

/**
 * @Description: 方形
 * @Author: Bruce
 * @Datetime: 2018/3/2 10:51
 */
public class SquareShape implements Shape {

    public void draw() {
        System.out.println("绘制方形");
    }

    public void erase() {
        System.out.println("擦除方形");
    }
}
