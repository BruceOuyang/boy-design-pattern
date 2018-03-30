package bugmakers.club.dp.behavioral.seq08.state.demooptimized.switchstate;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/29 17:36
 */
public class OffState extends SwitchState {

    @Override
    public void on(Switch s) {
        System.out.println("打开");
        s.setState(Switch.getState("on"));
    }

    @Override
    public void off(Switch s) {
        System.out.println("已经关闭");
    }
}
