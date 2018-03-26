package bugmakers.club.dp.behavioral.seq05.mediator.demo;

/**
 * @Description: 文本框类：具体同事类
 * @Author: Bruce
 * @Datetime: 2018/3/26 14:23
 */
public class TextBox extends Component {

    @Override
    public void update() {
        System.out.println("客户信息增加成功后文本框清空");
    }

    public void setText() {
        System.out.println("文本框显示：小龙女");
    }
}
