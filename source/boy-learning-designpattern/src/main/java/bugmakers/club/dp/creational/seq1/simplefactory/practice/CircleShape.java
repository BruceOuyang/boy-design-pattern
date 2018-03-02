package bugmakers.club.dp.creational.seq1.simplefactory.practice;

/**
 * @Description: 圆形
 * @Author: Bruce
 * @Datetime: 2018/3/2 10:51
 */
public class CircleShape implements Shape {

    public void draw() {
        System.out.println("绘制圆形");
    }

    public void erase() {
        System.out.println("擦除圆形");
    }
}
