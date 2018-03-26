package bugmakers.club.dp.behavioral.seq06.memento.structural;

/**
 * @Description: 负责人类
 * @Author: Bruce
 * @Datetime: 2018/3/26 16:28
 */
public class Caretaker {

    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
