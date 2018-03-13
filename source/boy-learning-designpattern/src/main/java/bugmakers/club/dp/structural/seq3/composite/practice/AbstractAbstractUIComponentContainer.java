package bugmakers.club.dp.structural.seq3.composite.practice;

import java.util.ArrayList;

/**
 * @Description: 抽象容器控件
 * @Author: Bruce
 * @Datetime: 2018/3/13 14:02
 */
public abstract class AbstractAbstractUIComponentContainer extends AbstractUIComponent {

    private ArrayList<AbstractUIComponent> list = new ArrayList<AbstractUIComponent>();

    public AbstractAbstractUIComponentContainer(String title){
        this.title = title;
    }

    /**
     * 初始化容器
     */
    public abstract void init();

    @Override
    public void show() {
        System.out.println("展示title为" + title + "的容器控件");
    }

    /**
     * 添加一个控件到容器内
     * @return
     */
    public void add(AbstractUIComponent component){
        list.add(component);
    }

    /**
     * 移除一个容器内的控件
     * @param component
     */
    public void remove(AbstractUIComponent component){
        list.remove(component);
    }

    /**
     * 从容器中获取一个控件
     * @param i
     * @return
     */
    public AbstractUIComponent get(int i){
        return list.get(i);
    }
}
