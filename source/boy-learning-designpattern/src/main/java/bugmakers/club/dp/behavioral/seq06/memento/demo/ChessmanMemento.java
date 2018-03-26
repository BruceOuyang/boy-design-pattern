package bugmakers.club.dp.behavioral.seq06.memento.demo;

/**
 * @Description: 象棋棋子备忘录类：备忘录
 * @Author: Bruce
 * @Datetime: 2018/3/26 18:00
 */
public class ChessmanMemento {

    private String label;
    private int x;
    private int y;

    public ChessmanMemento(String label, int x, int y) {
        this.label = label;
        this.x = x;
        this.y = y;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
