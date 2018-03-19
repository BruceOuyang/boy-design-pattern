package bugmakers.club.dp.behavioral.seq02.command.demooptimized.commandqueue;

import bugmakers.club.dp.behavioral.seq02.command.demo.Command;

import java.util.ArrayList;

/**
 * @Description: 负责存储多个命令对象
 * @Author: Bruce
 * @Datetime: 2018/3/19 14:48
 */
public class CommandQueue {

    /**
     * 定义一个ArrayList来存储命令队列
     */
    private ArrayList<Command> commands = new ArrayList<Command>();

    public void addCommand(Command command){
        this.commands.add(command);
    }

    public void removeCommand(Command command){
        this.commands.remove(command);
    }

    public void execute(){
        for (Command command : commands) {
            command.execute();
        }
    }
}
