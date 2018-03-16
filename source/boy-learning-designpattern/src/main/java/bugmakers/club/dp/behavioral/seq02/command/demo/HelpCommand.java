package bugmakers.club.dp.behavioral.seq02.command.demo;

/**
 * @Description: 帮助命令类：具体命令类
 * @Author: Bruce
 * @Datetime: 2018/3/16 17:30
 */
public class HelpCommand extends Command {

    private HelpHandler helpHandler;

    public HelpCommand() {
        this.helpHandler = new HelpHandler();
    }

    @Override
    public void execute() {
        this.helpHandler.display();
    }
}
