package bugmakers.club.dp.behavioral.seq06.memento.practice;

/**
 * @Description: 游戏的备忘录
 * @Author: Bruce
 * @Datetime: 2018/3/27 16:01
 */
public class DpGameMemento {

    private String level;

    public DpGameMemento(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
