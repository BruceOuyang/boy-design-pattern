package bugmakers.club.dp.structural.seq3.composite.practice;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/13 13:29
 */
public class Panel extends AbstractUIComponent {

    public Panel(String title) {
        this.title = title;
    }

    @Override
    public void show() {
        System.out.println("展示" + title + "面板");
    }
}
