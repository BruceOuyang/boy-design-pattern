package bugmakers.club.dp.creational.seq5.prototype.demo;

/**
 * @Description: 日志附件类
 * @Author: Bruce
 * @Datetime: 2018/3/7 17:43
 */
public class Attachment {

    /**
     * 附件名称
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void download(){
        System.out.println("下载附件，文件名为" + name);
    }
}
