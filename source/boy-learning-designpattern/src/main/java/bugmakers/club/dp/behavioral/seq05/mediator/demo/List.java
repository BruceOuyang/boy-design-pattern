package bugmakers.club.dp.behavioral.seq05.mediator.demo;

/**
 * @Description: 列表框类：具体同事类
 * @Author: Bruce
 * @Datetime: 2018/3/26 14:20
 */
public class List extends Component {

    @Override
    public void update() {
        System.out.println("列表框增加一项：张无忌");
    }

    public void select(){
        System.out.println("列表框选择：小龙女");
    }
}
