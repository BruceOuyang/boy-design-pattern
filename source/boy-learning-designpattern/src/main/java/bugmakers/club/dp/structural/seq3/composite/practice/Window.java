package bugmakers.club.dp.structural.seq3.composite.practice;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/13 13:30
 */
public class Window extends AbstractUIComponentContainer {

    public Window(String title){
        this.title = title;
        init();
    }

    @Override
    public void init() {
        System.out.println("初始化容器控件：" + title + "窗口");
    }

}
