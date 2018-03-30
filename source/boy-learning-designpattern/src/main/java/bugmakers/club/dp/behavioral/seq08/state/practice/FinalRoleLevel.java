package bugmakers.club.dp.behavioral.seq08.state.practice;

/**
 * @Description: 骨灰级
 * @Author: Bruce
 * @Datetime: 2018/3/30 17:04
 */
public class FinalRoleLevel extends RoleLevel {

    public FinalRoleLevel(Player player) {
        System.out.print("恭喜您升级为骨灰级别，");
        this.doubleScore();
        this.peekCards();
        this.player = player;
    }

    @Override
    public String toString() {
        return "骨灰级";
    }

    @Override
    public void checkLevel() {
    }
}
