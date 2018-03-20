package bugmakers.club.dp.behavioral.seq02.command.demooptimized.undo;

import java.util.ArrayList;

/**
 * @Description: 具体命令类
 * @Author: Bruce
 * @Datetime: 2018/3/19 16:41
 */
public class ConcreteCalcuCommand extends AbstractCalcuCommand {

    private Adder adder = new Adder();
    private int value;

    /**
     * 实现抽象命令类中声明的execute()方法，调用加法类的加法操作，记录一次状态
     * @param value
     * @return
     */
    @Override
    public int execute(int value) {
        this.value = value;
        return adder.add(value);
    }

    /**
     * 实现抽象命令类中声明的undo()方法，通过加一个相反数来实现加法的逆向操作，删除一次状态
     */
    @Override
    public int undo() {
        int result = adder.add(-value);
        return result;
    }

    /**
     * 实现抽象命令类中声明的redo()方法，记录一次状态
     * @return
     */
    @Override
    public int redo() {

        int result = 0;
        return result;
    }
}
