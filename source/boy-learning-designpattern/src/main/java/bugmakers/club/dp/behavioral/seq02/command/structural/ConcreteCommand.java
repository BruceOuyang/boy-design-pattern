package bugmakers.club.dp.behavioral.seq02.command.structural;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/16 15:38
 */
public class ConcreteCommand extends Command {

    /**
     * 维持一个对请求接收者对象的引用
     */
    private Receiver receiver;

    @Override
    public void execute() {
        // 调用请求接收者的业务处理方法action()
        this.receiver.action();
    }
}
