package bugmakers.club.dp.behavioral.seq06.memento.practice;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/27 16:23
 */
public class MementoPracticeClient {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {

        DpGameCaretaker dpGameCaretaker = new DpGameCaretaker();

        DpGame game = new DpGame();
        game.setLevel("1级");
        showLevel(game);

        game.setLevel("5级");
        showLevel(game);
        dpGameCaretaker.setMemento("L5", game.save());

        game.setLevel("15级");
        showLevel(game);
        dpGameCaretaker.setMemento("L15", game.save());

        System.out.println("---------");
        System.out.println("----挂了----");
        System.out.println("---------");

        game.restore(dpGameCaretaker.getMemento("L15"));
    }

    public static void showLevel(DpGame game){
        System.out.println("当前等级：" + game.getLevel());
    }
}
