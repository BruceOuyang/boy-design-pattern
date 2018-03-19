package bugmakers.club.dp.behavioral.seq02.command.demooptimized.undo;

import java.text.MessageFormat;
import java.util.ArrayList;

/**
 * @Description: 计算器界面类：请求发送者
 * @Author: Bruce
 * @Datetime: 2018/3/19 16:45
 */
public class CalculatorForm {

    /**
     * 计算命令
     */
    private AbstractCalcuCommand command;

    /**
     * 注入命令
     * @param command
     */
    public void setCommand(AbstractCalcuCommand command) {
        this.command = command;
    }

    /**
     * 调用命令对象的execute()方法执行运算
     * @param value
     */
    public void compute(int value){

        int i = this.command.execute(value);
        System.out.println(MessageFormat.format("执行运算，运算结果为：{0}", i));
    }

    /**
     * 调用命令对象的undo()方法执行撤销
     */
    public void undo(){
        int i = this.command.undo();
        System.out.println(MessageFormat.format("执行运算，运算结果为：{0}", i));
    }

    public void redo(){
        int i = this.command.redo();
        System.out.println(MessageFormat.format("执行运算，运算结果为：{0}", i));
    }

}
