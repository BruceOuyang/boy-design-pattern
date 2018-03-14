package bugmakers.club.dp.structural.seq4.decorator.demo;

/**
 * @Description: 构件装饰类：抽象装饰类
 * @Author: Bruce
 * @Datetime: 2018/3/14 13:48
 */
public class ComponentDecorator extends Component {

    /**
     * 维持对抽象构件类型对象的引用
     */
    private Component component;

    /**
     * 注入抽象构件类型的对象
     * @param component
     */
    public ComponentDecorator(Component component){
        this.component = component;
    }

    @Override
    public void display() {
        component.display();
    }
}
