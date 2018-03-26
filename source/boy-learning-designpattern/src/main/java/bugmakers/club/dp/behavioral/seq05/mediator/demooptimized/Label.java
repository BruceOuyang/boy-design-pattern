package bugmakers.club.dp.behavioral.seq05.mediator.demooptimized;

import bugmakers.club.dp.behavioral.seq05.mediator.demo.Component;

/**
 * @Description: 文本标签类：具体同事类
 * @Author: Bruce
 * @Datetime: 2018/3/26 14:59
 */
public class Label extends Component {

    @Override
    public void update() {
        System.out.println("文本标签内容改变，客户信息总数加1。");
    }
}
