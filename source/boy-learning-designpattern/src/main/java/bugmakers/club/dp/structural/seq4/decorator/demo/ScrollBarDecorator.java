package bugmakers.club.dp.structural.seq4.decorator.demo;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/14 13:51
 */
public class ScrollBarDecorator extends ComponentDecorator {
    /**
     * 注入抽象构件类型的对象
     *
     * @param component
     */
    public ScrollBarDecorator(Component component) {
        super(component);
    }

    @Override
    public void display() {
        setScrollBar();
        super.display();
    }

    public void setScrollBar(){
        System.out.println("添加滚动条");
    }
}
