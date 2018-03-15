package bugmakers.club.dp.structural.seq6.flyweight.demooptimized;

/**
 * @Description: 增加外部状态的抽象享元对象
 * @Author: Bruce
 * @Datetime: 2018/3/15 14:57
 */
public abstract class AbstractIgoChessman {

    public abstract String getColor();

    public void display(Coordinates coord){
        System.out.println("棋子颜色：" + this.getColor() + "，棋子位置：" + coord.getX() + "，" + coord.getY());
    }
}
