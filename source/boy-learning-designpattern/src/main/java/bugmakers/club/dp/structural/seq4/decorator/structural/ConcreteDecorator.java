package bugmakers.club.dp.structural.seq4.decorator.structural;

/**
 * @Description: 具体装饰器
 * @Author: Bruce
 * @Datetime: 2018/3/14 13:32
 */
public class ConcreteDecorator extends Decorator {

    public ConcreteDecorator(AbstractComponent component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        addBehavior();
    }

    /**
     * 增加新行为
     */
    public void addBehavior(){

    }
}
