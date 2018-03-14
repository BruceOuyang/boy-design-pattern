package bugmakers.club.dp.structural.seq3.composite.practice;

/**
 * @Description: 抽象单元控件
 * @Author: Bruce
 * @Datetime: 2018/3/13 14:01
 */
public abstract class AbstractUIComponentUnit extends AbstractUIComponent {

    @Override
    public abstract void init();

    @Override
    public void show() {
        System.out.println("显示单元控件：" + title);
    }
}
