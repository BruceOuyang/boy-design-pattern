package bugmakers.club.dp.behavioral.seq05.mediator.demooptimized;

import bugmakers.club.dp.behavioral.seq05.mediator.demo.*;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/26 14:26
 */
public class MediatorDemooptimizedClient {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {

        // 定义中介者
        SubConcreteMediator mediator = new SubConcreteMediator();

        // 定义同事对象
        Button button = new Button();
        List list = new List();
        ComboBox combobox = new ComboBox();
        TextBox textbox = new TextBox();
        Label label = new Label();

        // 设置同事对象
        button.setMediator(mediator);
        list.setMediator(mediator);
        combobox.setMediator(mediator);
        textbox.setMediator(mediator);
        label.setMediator(mediator);

        // 设置中介者
        mediator.button = button;
        mediator.list = list;
        mediator.comboBox = combobox;
        mediator.textBox = textbox;
        mediator.label = label;

        // 模拟操作
        button.changed();
        System.out.println("------------------");
        list.changed();
        System.out.println("------------------");
        combobox.changed();
    }
}
