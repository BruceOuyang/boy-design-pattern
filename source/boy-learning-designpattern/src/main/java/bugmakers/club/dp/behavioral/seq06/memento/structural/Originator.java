package bugmakers.club.dp.behavioral.seq06.memento.structural;

/**
 * @Description: 原发器类
 * @Author: Bruce
 * @Datetime: 2018/3/26 16:22
 */
public class Originator {

    private String state;

    /**
     * 创建一个备忘录对象
     * @return
     */
    public Memento createMemento(){
        return new Memento(this);
    }

    /**
     * 根据备忘录对象恢复原发器状态
     * @param memento
     */
    public void restoreMemento(Memento memento){
        state = memento.getState();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
