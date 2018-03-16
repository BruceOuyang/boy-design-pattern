package bugmakers.club.dp.behavioral.seq02.command.structural;

/**
 * @Description: 请求发送者
 * @Author: Bruce
 * @Datetime: 2018/3/16 15:20
 */
public class Invoker {

    private Command command;

    /**
     * 构造注入
     * @param command
     */
    public Invoker(Command command){
        this.command = command;
    }

    /**
     * 设置注入
     * @param command
     */
    public void setCommand(Command command) {
        this.command = command;
    }

    /**
     * 业务方法，用于调用命令类的execute()方法
     */
    public void call(){
        this.command.execute();
    }
}
