package bugmakers.club.dp.creational.seq5.prototype.demooptimized.deepclone;

import java.io.*;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/7 17:44
 */
public class DeepCloneWeeklyLog implements Serializable {

    private String name;
    private String date;
    private String content;
    private Attachment attachment;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

    /**
     * 使用序列化技术实现深克隆
     * @return
     */
    public DeepCloneWeeklyLog deepClone() throws  IOException, ClassNotFoundException{
        //将对象写入流中
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bao);
        oos.writeObject(this);

        //将对象从流中取出
        ByteArrayInputStream bis=new  ByteArrayInputStream(bao.toByteArray());
        ObjectInputStream ois=new  ObjectInputStream(bis);
        return  (DeepCloneWeeklyLog)ois.readObject();
    }
}
