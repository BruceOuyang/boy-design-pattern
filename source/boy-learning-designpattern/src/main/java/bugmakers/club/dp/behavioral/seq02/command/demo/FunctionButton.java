package bugmakers.club.dp.behavioral.seq02.command.demo;

import java.text.MessageFormat;

/**
 * @Description: 功能键类，请求发送者
 * @Author: Bruce
 * @Datetime: 2018/3/16 17:17
 */
public class FunctionButton {

    /**
     * 功能键名字
     */
    private String name;

    /**
     * 维持一个抽象命令对象的引用
     */
    private Command command;

    public FunctionButton(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * 为功能键注入命令
     * @param command
     */
    public void setCommand(Command command) {
        this.command = command;
    }

    /**
     * 发送请求的方法
     */
    public void onClick(){
        System.out.println(MessageFormat.format("点击{0}：", this.name));
        this.command.execute();
    }
}
