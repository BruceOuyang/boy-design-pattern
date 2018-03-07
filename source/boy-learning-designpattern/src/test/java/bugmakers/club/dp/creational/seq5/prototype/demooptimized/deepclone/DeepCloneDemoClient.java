package bugmakers.club.dp.creational.seq5.prototype.demooptimized.deepclone;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/7 17:59
 */
public class DeepCloneDemoClient {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {
        DeepCloneWeeklyLog log_previous, log_new = null;
        log_previous  = new DeepCloneWeeklyLog(); //创建原型对象
        Attachment attachment = new Attachment(); //创建附件对象
        log_previous.setAttachment(attachment);  //将附件添加到周报中
        try
        {
            log_new =  log_previous.deepClone(); //调用深克隆方法创建克隆对象
        }
        catch(Exception e)
        {
            System.err.println("克隆失败！");
        }
        //比较周报
        System.out.println("周报是否相同？ " + (log_previous ==  log_new));
        //比较附件
        System.out.println("附件是否相同？ " +  (log_previous.getAttachment() == log_new.getAttachment()));
    }
}
