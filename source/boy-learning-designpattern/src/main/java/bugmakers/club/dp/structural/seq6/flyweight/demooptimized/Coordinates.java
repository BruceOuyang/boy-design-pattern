package bugmakers.club.dp.structural.seq6.flyweight.demooptimized;

/**
 * @Description: 坐标类：外部状态类
 * @Author: Bruce
 * @Datetime: 2018/3/15 14:56
 */
public class Coordinates {

    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
