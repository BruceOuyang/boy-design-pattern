package bugmakers.club.dp.behavioral.seq08.state.demooptimized.switchstate;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/29 17:35
 */
public class OnState extends SwitchState {

    @Override
    public void on(Switch s) {
        System.out.println("已经打开");
    }

    @Override
    public void off(Switch s) {
        System.out.println("关闭");
        s.setState(Switch.getState("off"));
    }
}
