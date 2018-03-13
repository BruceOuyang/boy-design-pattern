package bugmakers.club.dp.structural.seq3.composite.practice;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/13 13:30
 */
public class Window extends UIComponent {

    private ArrayList<UIComponent> list = new ArrayList<UIComponent>();

    public Window add(UIComponent component) {
        list.add(component);
        return this;
    }
    public void remove(UIComponent component) {
        list.remove(component);
    }
    public UIComponent get(int i) {
        return list.get(i);
    }

    @Override
    public void show() {
        System.out.println("展示窗口");
        for(UIComponent component : list) {
            component.show();
        }
    }
}
