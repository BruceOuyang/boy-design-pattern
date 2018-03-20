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
    private ArrayList<Integer> undoHistoryStat = new ArrayList<Integer>();
    private ArrayList<Integer> redoHistoryStat = new ArrayList<Integer>();

    private Adder adder = new Adder();
    private int value;

    /**
     * 实现抽象命令类中声明的execute()方法，调用加法类的加法操作，记录一次状态
     * @param value
     * @return
     */
    @Override
    public int execute(int value) {

        this.undoHistoryStat.add(value);

        this.value = value;
        return adder.add(value);
    }

    /**
     * 实现抽象命令类中声明的undo()方法，通过加一个相反数来实现加法的逆向操作，删除一次状态
     */
    @Override
    public int undo() {

        int result;

        int index = this.undoHistoryStat.indexOf(value);
        if(index != 0){

            // 计算结果
            result = adder.add(-value);

            // 设置value
            value = this.undoHistoryStat.get(index - 1);

            // 移除undo历史状态
            this.undoHistoryStat.remove(index);

            // 添加redo历史状态
            this.redoHistoryStat.add(value);
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

        int result;

        int index = this.redoHistoryStat.indexOf(value);

        if(index != 0){

            // 执行运算
            result = adder.add(value);

            // 设置value
            value = this.redoHistoryStat.get(index - 1);

            // 移除redo历史状态
            this.redoHistoryStat.remove(index);

            // 添加undo历史状态
            this.undoHistoryStat.add(value);
        }
        else{

            result = value;
        }

        // 返回结果
        return result;
    }
}
