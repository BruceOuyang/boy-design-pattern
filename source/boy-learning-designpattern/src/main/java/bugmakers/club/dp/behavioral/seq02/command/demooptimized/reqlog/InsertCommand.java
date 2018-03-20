package bugmakers.club.dp.behavioral.seq02.command.demooptimized.reqlog;

/**
 * @Description: 增加命令类：具体命令
 * @Author: Bruce
 * @Datetime: 2018/3/20 11:13
 */
public class InsertCommand extends AbstractLogCommand {

    public InsertCommand(String name) {
        super(name);
    }

    @Override
    public void execute(String args) {
        this.args = args;
        this.configOperator.insert(args);
    }

    @Override
    public void execute() {
        this.configOperator.insert(this.args);
    }
}
