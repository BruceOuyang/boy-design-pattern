package bugmakers.club.dp.structural.seq4.decorator.demo;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/14 13:56
 */
public class DecoratorDemoClient {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {
        Component component, scrollBarDecorator, blackBorderDecorator;

        component = new Window();

        scrollBarDecorator = new ScrollBarDecorator(component);
        blackBorderDecorator = new BlackBorderDecorator(scrollBarDecorator);

        blackBorderDecorator.display();
    }
}
