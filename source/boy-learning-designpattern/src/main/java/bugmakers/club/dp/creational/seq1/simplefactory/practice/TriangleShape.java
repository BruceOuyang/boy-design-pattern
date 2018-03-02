package bugmakers.club.dp.creational.seq1.simplefactory.practice;

/**
 * @Description: 三角形
 * @Author: Bruce
 * @Datetime: 2018/3/2 10:51
 */
public class TriangleShape implements Shape {

    public void draw() {
        System.out.println("绘制三角形");
    }

    public void erase() {
        System.out.println("擦除三角形");
    }
}
