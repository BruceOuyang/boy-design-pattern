package bugmakers.club.dp.behavioral.seq08.state.demooptimized;

import bugmakers.club.dp.behavioral.seq08.state.demooptimized.zoomstate.Screen;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/30 11:06
 */
public class StateDemoZoomClient {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {
        Screen screen = new Screen();
        screen.onClick();
        screen.onClick();
        screen.onClick();
        screen.onClick();
    }
}
