package bugmakers.club.dp.behavioral.seq05.mediator.practice;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/26 15:33
 */
public class MediatorPracticeClient {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {

        // 定义一个窗口对象
        Window window = new Window();

        // 定义一些面板
        TextPanel text = new TextPanel();
        ListPanel list = new ListPanel();
        GraphicPanel graphic = new GraphicPanel();

        // 设置面板的中介者对象
        text.setMediator(window);
        list.setMediator(window);
        graphic.setMediator(window);

        // 设置窗口中的对象
        window.text = text;
        window.list = list;
        window.graphic = graphic;

        // 模拟操作
        text.interactive();
    }
}
