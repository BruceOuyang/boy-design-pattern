package bugmakers.club.dp.structural.seq3.composite.practice;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/13 13:30
 */
public class Window extends AbstractUIComponent {

    public Window(String title) {
        this.title = title;
    }

    private ArrayList<AbstractUIComponent> list = new ArrayList<AbstractUIComponent>();

    public Window add(AbstractUIComponent component) {
        list.add(component);
        return this;
    }
    public void remove(AbstractUIComponent component) {
        list.remove(component);
    }
    public AbstractUIComponent get(int i) {
        return list.get(i);
    }

    @Override
    public void show() {
        System.out.println("展示" + title + "窗口");
        for(AbstractUIComponent component : list) {
            component.show();
        }
    }
}
