package bugmakers.club.dp.behavioral.seq06.memento.demo;

/**
 * @Description: 象棋棋子备忘录管理类：负责人
 * @Author: Bruce
 * @Datetime: 2018/3/26 18:03
 */
public class MementoCaretaker {

    private ChessmanMemento memento;

    public ChessmanMemento getMemento() {
        return memento;
    }

    public void setMemento(ChessmanMemento memento) {
        this.memento = memento;
    }
}
