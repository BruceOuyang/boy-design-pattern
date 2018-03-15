package bugmakers.club.dp.structural.seq6.flyweight.practice;

/**
 * @Description: 抽象
 * @Author: Bruce
 * @Datetime: 2018/3/15 15:22
 */
public abstract class AbstractAsset {

    /**
     * 资源文件类型{pic/animation/video}
     * @return
     */
    public abstract String type();

    public void insert(Position position, Size size){
        System.out.println("向文档中插入" + this.type() + ", 位置：" + position.getX() + "," + position.getY() + ", 宽：" + size.getWidth() + ", 高：" + size.getHeight());
    }
}
