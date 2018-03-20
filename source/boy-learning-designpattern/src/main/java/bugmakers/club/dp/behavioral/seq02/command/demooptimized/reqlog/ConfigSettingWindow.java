package bugmakers.club.dp.behavioral.seq02.command.demooptimized.reqlog;

import java.util.ArrayList;

/**
 * @Description: 配置文件设置窗口类：请求发送者
 * @Author: Bruce
 * @Datetime: 2018/3/20 11:20
 */
public class ConfigSettingWindow {

    /**
     * 定义一个集合来存储每一次操作时的命令对象
     */
    private ArrayList<AbstractLogCommand> commands = new ArrayList<AbstractLogCommand>();

    private AbstractLogCommand command;

    /**
     * 注入具体命令对象
     * @param command
     */
    public void setCommand(AbstractLogCommand command) {
        this.command = command;
    }

    /**
     * 执行配置文件修改命令，同时将命令对象添加到命令集合中
     * @param args
     */
    public void call(String args){
        command.execute(args);
        commands.add(command);
    }

    /**
     * 记录请求日志，生成日志文件，将命令集合写入日志文件
     */
    public void save(){
        ReqLogFileUtil.writeCommands(commands);
    }

    /**
     * 从日志文件中提取命令集合，并循环调用每一个命令对象的execute()方法来实现配置文件的重新设置
     */
    public void recover(){
        ArrayList<AbstractLogCommand> commands = ReqLogFileUtil.readCommands();
        for(AbstractLogCommand command : commands){
            command.execute();
        }
    }
}
