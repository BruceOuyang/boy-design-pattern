package bugmakers.club.dp.structural.seq3.composite.structural;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/13 9:38
 */
public class Composite extends Component {

    private ArrayList<Component> list = new ArrayList<Component>();

    @Override
    public void add(Component c) {
        list.add(c);
    }

    @Override
    public void remove(Component c) {
        list.remove(c);
    }

    @Override
    public Component getChild(int i) {
        return (Component)list.get(i);
    }

    @Override
    public void operation() {

        //容器构件具体业务方法的实现

        //递归调用成员构件的业务方法
        for(Object obj:list) {
            ((Component)obj).operation();
        }
    }
}
