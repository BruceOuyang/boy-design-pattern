package bugmakers.club.dp.behavioral.seq02.command.demo;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/16 17:46
 */
public class CommandDemoClient {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {

        FBSettingWindow window = new FBSettingWindow("功能键设置");

        FunctionButton fb1, fb2;
        fb1 = new FunctionButton("功能键A");
        fb2 = new FunctionButton("功能键B");

        Command c1, c2;
        c1 = CommandXMLUtil.getCommand(0);
        c2 = CommandXMLUtil.getCommand(1);

        fb1.setCommand(c1);
        fb2.setCommand(c2);

        window.addFunctionButton(fb1);
        window.addFunctionButton(fb2);

        window.display();

        fb1.onClick();
        fb2.onClick();
    }
}
