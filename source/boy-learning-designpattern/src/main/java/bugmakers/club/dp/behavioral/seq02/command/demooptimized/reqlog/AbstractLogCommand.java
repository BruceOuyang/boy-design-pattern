package bugmakers.club.dp.behavioral.seq02.command.demooptimized.reqlog;

import java.io.Serializable;

/**
 * @Description: 抽象命令类，由于需要将命令对象写入文件，因此它实现了Serializable接口
 * @Author: Bruce
 * @Datetime: 2018/3/20 11:05
 */
public abstract class AbstractLogCommand implements Serializable {

    /**
     * 命令名称
     */
    protected String name;

    /**
     * 命令参数
     */
    protected String args;

    /**
     * 维持对接收者对象的引用
     */
    protected ConfigOperator configOperator;

    public AbstractLogCommand(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setConfigOperator(ConfigOperator configOperator) {
        this.configOperator = configOperator;
    }

    /**
     * 含参执行方法
     * @param args
     */
    public abstract void execute(String args);

    /**
     * 无参执行方法
     */
    public abstract void execute();
}
