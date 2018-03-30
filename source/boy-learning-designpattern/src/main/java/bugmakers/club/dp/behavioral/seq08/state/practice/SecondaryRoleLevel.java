package bugmakers.club.dp.behavioral.seq08.state.practice;

/**
 * @Description: 熟练级
 * @Author: Bruce
 * @Datetime: 2018/3/30 17:04
 */
public class SecondaryRoleLevel extends RoleLevel {

    public SecondaryRoleLevel(Player player) {

        System.out.println("恭喜您升级为熟练级别，获得双倍积分奖励");
        this.doubleScore();
        this.player = player;
    }

    /**
     * 检查级别
     */
    @Override
    public void checkLevel(){
        if(this.player.getPoints() >= PP){
            this.player.setRoleLevel(new ProfessionalRoleLevel(player));
        }
    }

    @Override
    public String toString() {
        return "熟练级";
    }
}
