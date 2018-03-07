package bugmakers.club.dp.creational.seq5.prototype.demooptimized.shallowclone;

import bugmakers.club.dp.creational.seq5.prototype.demo.Attachment;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/7 17:44
 */
public class ShallowCloneWeeklyLog implements Cloneable {

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
     * 使用clone()方法实现浅克隆
     * @return
     */
    @Override
    public ShallowCloneWeeklyLog clone(){
        try {
            return (ShallowCloneWeeklyLog)super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("不支持复制");
            return null;
        }
    }
}
