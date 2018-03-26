package bugmakers.club.dp.behavioral.seq05.mediator.demo;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/26 14:22
 */
public class ComboBox extends Component {

    @Override
    public void update() {
        System.out.println("组合框增加一项：张无忌");
    }

    public void select() {
        System.out.println("组合框选中：小龙女");
    }
}
