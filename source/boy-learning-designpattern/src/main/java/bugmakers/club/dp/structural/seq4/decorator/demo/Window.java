package bugmakers.club.dp.structural.seq4.decorator.demo;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/14 13:46
 */
public class Window extends Component {

    public Window(){
        System.out.println("创建窗体");
    }

    @Override
    public void display() {
        System.out.println("展示窗体！");
    }
}
