package bugmakers.club.dp.structural.seq3.composite.structural.objectoriented;

import bugmakers.club.dp.structural.seq3.composite.structural.Component;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/12 16:11
 */
public class Composite extends Component {

    private ArrayList<Component> list = new ArrayList<Component>();

    @Override
    public void add(Component component) {
        this.list.add(component);
    }

    @Override
    public void remove(Component component) {
        this.list.remove(component);
    }

    @Override
    public Component getChild(int i) {
        return this.list.get(i);
    }

    @Override
    public void operation() {

        // 容器构件具体业务方法的实现
        // ...

        // 递归调用成员构件的业务方法
        for(Component component : list) {
            component.operation();
        }
    }
}
