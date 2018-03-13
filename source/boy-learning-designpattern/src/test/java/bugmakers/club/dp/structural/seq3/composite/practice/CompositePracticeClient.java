package bugmakers.club.dp.structural.seq3.composite.practice;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/13 13:33
 */
public class CompositePracticeClient {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {

        UIComponent panel, text, button = null;

        panel = new Panel();
        text = new Text();
        button = new Button();

        new Window().add(panel).add(text).add(button).show();
    }
}
