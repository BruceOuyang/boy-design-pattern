package bugmakers.club.dp.structural.seq3.composite.practice;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/13 11:40
 */
public class Text extends AbstractUIComponentUnit {

    public Text(String title) {
        this.title = title;
        init();
    }

    @Override
    public void init() {
        System.out.println("初始化单元控件：" + title + "文本框");
    }

}
