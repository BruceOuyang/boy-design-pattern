package bugmakers.club.dp.behavioral.seq05.mediator.demooptimized;

import bugmakers.club.dp.behavioral.seq05.mediator.demo.ConcreteMediator;

/**
 * @Description: 新增具体中介者类
 * @Author: Bruce
 * @Datetime: 2018/3/26 14:57
 */
public class SubConcreteMediator extends ConcreteMediator {

    public Label label;

    @Override
    protected void buttonChanged() {
        super.buttonChanged();
        label.update();
    }
}
