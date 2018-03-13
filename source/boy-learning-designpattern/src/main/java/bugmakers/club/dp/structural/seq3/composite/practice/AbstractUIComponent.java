package bugmakers.club.dp.structural.seq3.composite.practice;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/13 11:39
 */
public abstract class AbstractUIComponent {

    protected String title;

    /**
     * 初始化控件
     */
    public abstract void init();

    /**
     * 显示控件
     */
    public abstract void show();
}
