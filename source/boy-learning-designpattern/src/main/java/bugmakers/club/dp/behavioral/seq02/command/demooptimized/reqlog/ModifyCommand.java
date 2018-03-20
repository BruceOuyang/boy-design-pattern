package bugmakers.club.dp.behavioral.seq02.command.demooptimized.reqlog;

/**
 * @Description: 修改命令类：具体命令
 * @Author: Bruce
 * @Datetime: 2018/3/20 11:15
 */
public class ModifyCommand extends AbstractLogCommand {

    public ModifyCommand(String name) {
        super(name);
    }

    @Override
    public void execute(String args) {
        this.args = args;
        this.configOperator.modify(args);
    }

    @Override
    public void execute() {
        this.configOperator.modify(args);
    }
}
