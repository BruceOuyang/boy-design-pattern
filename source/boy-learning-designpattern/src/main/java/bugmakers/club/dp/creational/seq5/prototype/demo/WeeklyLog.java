package bugmakers.club.dp.creational.seq5.prototype.demo;

import java.util.Date;

/**
 * @Description: 工作周报WeeklyLog：具体原型类，考虑到代码的可读性和易理解性，只列出部分与模式相关的核心代码
 * @Author: Bruce
 * @Datetime: 2018/3/7 17:28
 */
public class WeeklyLog implements Cloneable {

    private String name;
    private String date;
    private String content;

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

    /**
     * 克隆方法clone()，此处使用Java语言提供的克隆机制
     * @return
     */
    @Override
    public WeeklyLog clone(){
        Object obj;
        try {
            obj = super.clone();
            return (WeeklyLog)obj;
        } catch (CloneNotSupportedException e) {
            System.out.println("不支持复制");
            return null;
        }
    }
}
