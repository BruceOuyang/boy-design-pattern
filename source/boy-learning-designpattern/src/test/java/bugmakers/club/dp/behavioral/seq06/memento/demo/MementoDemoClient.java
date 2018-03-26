package bugmakers.club.dp.behavioral.seq06.memento.demo;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/26 18:03
 */
public class MementoDemoClient {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {

        MementoCaretaker mc = new MementoCaretaker();
        Chessman chess = new Chessman("車", 1, 1);
        chess.display();

        //保存状态
        mc.setMemento(chess.save());

        chess.setY(4);
        chess.display();

        //保存状态
        mc.setMemento(chess.save());
        chess.display();

        chess.setX(5);
        chess.display();
        System.out.println("******悔棋******");

        //恢复状态
        chess.restore(mc.getMemento());
        chess.display();
    }
}
