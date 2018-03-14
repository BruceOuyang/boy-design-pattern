package bugmakers.club.dp.structural.seq4.decorator.structural;

/**
 * @Description: 抽象装饰器
 * @Author: Bruce
 * @Datetime: 2018/3/14 13:26
 */
public class Decorator implements AbstractComponent {

    private AbstractComponent component;

    public Decorator(AbstractComponent component){
        this.component = component;
    }

    public void operation() {
        component.operation();
    }
}
