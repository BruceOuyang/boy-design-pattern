package bugmakers.club.dp.behavioral.seq02.command.demo;

/**
 * @Description: 最小化命令类：具体命令类
 * @Author: Bruce
 * @Datetime: 2018/3/16 17:36
 */
public class MinimizeCommand extends Command {

    private WindowHandler windowHandler;

    public MinimizeCommand() {
        this.windowHandler = new WindowHandler();
    }

    @Override
    public void execute() {
        this.windowHandler.minimize();
    }
}
