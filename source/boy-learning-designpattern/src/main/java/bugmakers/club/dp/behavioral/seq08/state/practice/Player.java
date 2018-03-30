package bugmakers.club.dp.behavioral.seq08.state.practice;

import java.text.MessageFormat;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/30 17:14
 */
public class Player {

    private String name;

    /**
     * 玩家积分
     */
    private int points;

    /**
     * 当前角色级别
     */
    private RoleLevel roleLevel;

    public Player(String name) {

        // 玩家名称
        this.name = name;

        // 初始积分为0
        this.points = 0;

        // 初始级别为
        this.roleLevel = new PrimaryRoleLevel(this);

        System.out.println("恭喜您注册成功");
        this.showInfo();
    }

    public void play(){
        System.out.println("开始对局：小的们，给我杀");
        System.out.println("---------------------------------");
        this.roleLevel.play();
        this.showInfo();
    }

    public void showInfo(){
        System.out.println("---------------------------------");
        System.out.println(MessageFormat.format("昵称：{0}\t级别：{1}\t积分：{2}", this.name, this.roleLevel.toString(), this.points));
        System.out.println("\n");
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setRoleLevel(RoleLevel roleLevel) {
        this.roleLevel = roleLevel;
    }
}
