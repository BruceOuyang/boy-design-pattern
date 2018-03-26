package bugmakers.club.dp.behavioral.seq06.memento.demo;

import java.text.MessageFormat;

/**
 * @Description: 象棋棋子类：原发器
 * @Author: Bruce
 * @Datetime: 2018/3/26 17:56
 */
public class Chessman {

    private String label;
    private int x;
    private int y;

    public Chessman(String label, int x, int y) {
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

    /**
     * 保存状态
     * @return
     */
    public ChessmanMemento save(){
        return new ChessmanMemento(this.label, this.x, this.y);
    }

    /**
     * 恢复状态
     * @param memento
     */
    public void restore(ChessmanMemento memento){
        this.label = memento.getLabel();
        this.x = memento.getX();
        this.y = memento.getY();
    }

    /**
     * 展示棋子
     */
    public void display(){
        System.out.println(MessageFormat.format("棋子{0}当前位置为：第{1}行第{2}列。", this.label, this.x, this.y));
    }
}
