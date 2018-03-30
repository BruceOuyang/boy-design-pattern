package bugmakers.club.dp.behavioral.seq08.state.practice;

/**
 * @Description: 入门级
 * @Author: Bruce
 * @Datetime: 2018/3/30 17:02
 */
public class PrimaryRoleLevel extends RoleLevel {

    /**
     * 注入player
     * @param player
     */
    public PrimaryRoleLevel(Player player) {
        this.player = player;
    }

    /**
     * 检查级别
     */
    @Override
    public void checkLevel(){
        if(this.player.getPoints() >= SP){
            this.player.setRoleLevel(new SecondaryRoleLevel(player));
        }
    }

    @Override
    public String toString() {
        return "入门级";
    }
}
