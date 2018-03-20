package bugmakers.club.dp.behavioral.seq02.command.demooptimized.undo;

import java.util.ArrayList;

/**
 * @Description: 具体命令类
 * @Author: Bruce
 * @Datetime: 2018/3/19 16:41
 */
public class ConcreteCalcuCommand extends AbstractCalcuCommand {

    /**
     * 历史计算状态
     */
    private ArrayList<Integer> historyStat = new ArrayList<Integer>();

    private Adder adder = new Adder();
    private int value;

    /**
     * 实现抽象命令类中声明的execute()方法，调用加法类的加法操作，记录一次状态
     * @param value
     * @return
     */
    @Override
    public int execute(int value) {

        this.historyStat.add(value);

        this.value = value;
        return adder.add(value);
    }

    /**
     * 实现抽象命令类中声明的undo()方法，通过加一个相反数来实现加法的逆向操作，删除一次状态
     */
    @Override
    public int undo() {

        int result;

        int index = this.historyStat.indexOf(value);
        if(index != 0){

            // 计算结果
            result = adder.add(-value);

            // 移除历史状态
            value = this.historyStat.get(index - 1);
            this.historyStat.remove(value);
        }else{

            result = value;
        }

        return result;
    }

    /**
     * 实现抽象命令类中声明的redo()方法，记录一次状态
     * @return
     */
    @Override
    public int redo() {

        // 执行运算
        int result = adder.add(value);

        // 记录历史状态
        this.historyStat.add(value);

        // 返回结果
        return result;
    }
}
