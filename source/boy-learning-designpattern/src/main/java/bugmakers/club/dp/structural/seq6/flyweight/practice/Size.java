package bugmakers.club.dp.structural.seq6.flyweight.practice;

/**
 * @Description: 大小：外部变量
 * @Author: Bruce
 * @Datetime: 2018/3/15 15:26
 */
public class Size {

    private int width;
    private int height;

    public Size(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
