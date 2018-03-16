package bugmakers.club.dp.behavioral.seq01.chainofresponsibility.practice;

/**
 * @Description: 请假单
 * @Author: Bruce
 * @Datetime: 2018/3/16 9:30
 */
public class VocationRequest {

    /**
     * 请假单编号
     */
    private String vid;

    /**
     * 请假人
     */
    private String name;

    /**
     * 请假天数
     */
    private int days;

    public VocationRequest(String vid, String name, int days) {
        this.vid = vid;
        this.name = name;
        this.days = days;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
}
