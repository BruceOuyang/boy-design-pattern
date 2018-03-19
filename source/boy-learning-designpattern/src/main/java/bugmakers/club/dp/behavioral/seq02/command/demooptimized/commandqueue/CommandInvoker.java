package bugmakers.club.dp.behavioral.seq02.command.demooptimized.commandqueue;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/19 16:22
 */
public class CommandInvoker {

    /**
     * 维持一个CommandQueue对象的引用
     */
    private CommandQueue commandQueue;

    public CommandInvoker(CommandQueue commandQueue) {
        this.commandQueue = commandQueue;
    }

    public void setCommandQueue(CommandQueue commandQueue) {
        this.commandQueue = commandQueue;
    }

    public void call(){
        this.commandQueue.execute();
    }
}
