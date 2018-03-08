package bugmakers.club.dp.creational.seq6.builder.demo;

/**
 * @Description: 角色类：复杂产品
 * @Author: Bruce
 * @Datetime: 2018/3/8 17:02
 */
public class Actor {

    /**
     * 角色类型
     */
    private  String type;
    /**
     * 性别
     */
    private  String sex;
    /**
     * 脸型
     */
    private  String face;
    /**
     * 服装
     */
    private  String costume;
    /**
     * 发型
     */
    private  String hairstyle;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getCostume() {
        return costume;
    }

    public void setCostume(String costume) {
        this.costume = costume;
    }

    public String getHairstyle() {
        return hairstyle;
    }

    public void setHairstyle(String hairstyle) {
        this.hairstyle = hairstyle;
    }
}
