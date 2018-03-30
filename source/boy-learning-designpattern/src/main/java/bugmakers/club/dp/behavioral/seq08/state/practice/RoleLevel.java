package bugmakers.club.dp.behavioral.seq08.state.practice;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/30 16:57
 */
public abstract class RoleLevel {

    /**
     * Secondary Level Up Point
     */
    public static final int SP = 200;

    /**
     * Professional Level Up Point
     */
    public static final int PP = 500;

    /**
     * Final Level Up Point
     */
    public static final int FP = 1000;

    /**
     * 玩家
     */
    protected Player player;

    /**
     * 默认获胜一局奖励100积分
     */
    protected int winPoints = 100;

    /**
     * 开始对局
     */
    public void play(){
        System.out.println("恭喜您，对局获胜！奖励积分：" + winPoints);
        this.player.setPoints(this.player.getPoints() + winPoints);
        this.checkLevel();
    }

    /**
     * 检查级别
     */
    public abstract void checkLevel();

    /**
     * 熟练级增加了游戏胜利积分加倍功能doubleScore()
     */
    public void doubleScore() {
        winPoints = winPoints * 2;
    }

    /**
     * 高手级在熟练级基础上再增加换牌功能changeCards()
     */
    public void changeCards() {
        System.out.println("获得换牌功能");
    }

    public void peekCards() {
        System.out.println("获得看牌功能");
    }
}
