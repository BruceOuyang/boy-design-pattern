package bugmakers.club.dp.behavioral.seq02.command.demooptimized.reqlog;

import java.io.*;
import java.util.ArrayList;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/20 11:24
 */
public class ReqLogFileUtil {

    private static final String COMMAND_LOG = "config-repo/behavioral/seq02/command/config.log";

    /**
     * 将命令集合写入日志文件
     * @param commands
     */
    public static void writeCommands(ArrayList<AbstractLogCommand> commands){
        try {
            // 创建文件输出流，用于写文件
            FileOutputStream fos = new FileOutputStream(COMMAND_LOG);

            // 创建对象输出流用于将对象写入到文件流中
            ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(fos));

            // 将对象写入文件
            oos.writeObject(commands);

            // 关闭流
            oos.close();
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从日志文件中提取命令集合
     * @return
     */
    public static ArrayList<AbstractLogCommand> readCommands(){
        ArrayList<AbstractLogCommand> commands = null;
        try {
            FileInputStream fis = new FileInputStream(COMMAND_LOG);
            ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(fis));
            commands = (ArrayList<AbstractLogCommand>) ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return commands;
    }
}
