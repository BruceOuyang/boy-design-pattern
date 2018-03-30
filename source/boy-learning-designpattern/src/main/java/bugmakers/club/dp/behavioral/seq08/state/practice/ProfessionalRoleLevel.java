package bugmakers.club.dp.behavioral.seq08.state.practice;

/**
 * @Description: 高手级
 * @Author: Bruce
 * @Datetime: 2018/3/30 17:04
 */
public class ProfessionalRoleLevel extends RoleLevel {

    public ProfessionalRoleLevel(Player player) {
        System.out.print("恭喜您升级为高手级别，");
        this.doubleScore();
        this.changeCards();
        this.player = player;
    }

    @Override
    public void checkLevel(){
        if(this.player.getPoints() >= FP){
            this.player.setRoleLevel(new FinalRoleLevel(player));
        }
    }

    @Override
    public String toString() {
        return "高手级";
    }
}
