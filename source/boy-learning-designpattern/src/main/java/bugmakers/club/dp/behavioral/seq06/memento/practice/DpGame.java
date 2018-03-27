package bugmakers.club.dp.behavioral.seq06.memento.practice;

/**
 * @Description: 游戏
 * @Author: Bruce
 * @Datetime: 2018/3/27 16:00
 */
public class DpGame {

    /**
     * 等级
     */
    private String level;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * 保存游戏存档
     * @return
     */
    public DpGameMemento save(){
        return new DpGameMemento(level);
    }

    /**
     * 恢复游戏存档
     * @param memento
     */
    public void restore(DpGameMemento memento){
        this.level = memento.getLevel();
    }

}
