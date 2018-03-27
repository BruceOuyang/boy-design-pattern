package bugmakers.club.dp.behavioral.seq06.memento.demooptimized;

import bugmakers.club.dp.behavioral.seq06.memento.demo.Chessman;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/27 10:15
 */
public class MementoDemooptimizedClient {

    /**
     * 定义一个索引来记录当前状态所在位置
     */
    private static int index = -1;

    /**
     * 定义一个备忘录管理者
     */
    private static MementoCaretaker mc = new MementoCaretaker();

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {

        Chessman chess = new Chessman("車", 1, 1);
        play(chess);

        chess.setY(4);
        play(chess);

        chess.setX(5);
        play(chess);

        undo(chess, index);
        undo(chess, index);
        redo(chess, index);
        redo(chess, index);
    }

    /**
     * 下棋
     * @param chess
     */
    public static void play(Chessman chess){
        // 保存备忘录
        mc.setMemento(chess.save());

        // 更新位置
        index ++;

        // 展示
        chess.display();
    }

    /**
     * 悔棋
     * @param chess
     */
    public static void undo(Chessman chess, int i){
        System.out.println("******悔棋******");
        index --;

        // 撤销到上一个备忘录
        chess.restore(mc.getMemento(i-1));

        // 展示
        chess.display();
    }

    /**
     * 撤销悔棋
     * @param chess
     */
    public static void redo(Chessman chess, int i){
        System.out.println("******撤销悔棋******");
        index ++;

        // 恢复到下一个备忘录
        chess.restore(mc.getMemento(i+1));

        // 展示
        chess.display();
    }
}
