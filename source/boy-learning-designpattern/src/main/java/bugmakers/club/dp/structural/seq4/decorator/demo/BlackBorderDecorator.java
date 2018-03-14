package bugmakers.club.dp.structural.seq4.decorator.demo;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/14 13:53
 */
public class BlackBorderDecorator extends ComponentDecorator {
    /**
     * 注入抽象构件类型的对象
     *
     * @param component
     */
    public BlackBorderDecorator(Component component) {
        super(component);
    }

    @Override
    public void display() {
        setBlackBorder();
        super.display();
    }

    public void setBlackBorder(){
        System.out.println("添加黑色边框");
    }
}
