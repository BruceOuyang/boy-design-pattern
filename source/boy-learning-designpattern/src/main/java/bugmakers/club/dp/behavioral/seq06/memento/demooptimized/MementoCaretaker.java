package bugmakers.club.dp.behavioral.seq06.memento.demooptimized;

import bugmakers.club.dp.behavioral.seq06.memento.demo.ChessmanMemento;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/27 10:06
 */
public class MementoCaretaker {

    /**
     * 定义一个集合来存储多个备忘录
     */
    private List mementolist = new ArrayList();

    public ChessmanMemento getMemento(int i) {
        return (ChessmanMemento)mementolist.get(i);
    }

    public void setMemento(ChessmanMemento memento) {
        mementolist.add(memento);
    }
}
