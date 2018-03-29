package bugmakers.club.dp.behavioral.seq08.state.demooptimized;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/29 17:53
 */
public class StateDemooptimizedClient {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {
        Switch s1, s2;

        s1 = new Switch("开关1");
        s2 = new Switch("开关2");

        s1.on();
        s2.on();
        s1.off();
        s2.off();
        s1.on();
        s2.on();
    }
}
