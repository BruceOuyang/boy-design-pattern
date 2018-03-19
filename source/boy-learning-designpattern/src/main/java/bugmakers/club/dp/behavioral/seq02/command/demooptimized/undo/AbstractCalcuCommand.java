package bugmakers.club.dp.behavioral.seq02.command.demooptimized.undo;

import java.util.ArrayList;

/**
 * @Description: 抽象命令类
 * @Author: Bruce
 * @Datetime: 2018/3/19 16:40
 */
public abstract class AbstractCalcuCommand {

    /**
     * 执行命令
     * @param value
     * @return
     */
    public abstract int execute(int value);

    /**
     * 撤销执行
     * @return
     */
    public abstract int undo();

    /**
     * 重新执行
     * @return
     */
    public abstract int redo();
}
