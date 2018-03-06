package bugmakers.club.dp.creational.seq3.abstractfactory;

import bugmakers.club.dp.creational.seq3.abstractfactory.demo.factory.SkinFactory;
import bugmakers.club.dp.creational.seq3.abstractfactory.demo.factory.SpringSkinFactory;
import bugmakers.club.dp.creational.seq3.abstractfactory.demo.product.Button;
import bugmakers.club.dp.creational.seq3.abstractfactory.demo.product.ComboBox;
import bugmakers.club.dp.creational.seq3.abstractfactory.demo.product.TextField;
import bugmakers.club.dp.creational.seq3.abstractfactory.demooptimized.AbstractFactoryXMLUtil;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/6 11:14
 */
public class AbstractFactoryDemoClient {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {

        // 使用抽象层定义
        SkinFactory factory;
        Button bt;
        TextField tf;
        ComboBox cb;

//        factory = (SkinFactory) AbstractFactoryXMLUtil.getBean();

        factory = new SpringSkinFactory();

        bt = factory.createButton();
        tf = factory.createTextField();
        cb = factory.createComboBox();
        bt.display();
        tf.display();
        cb.display();
    }
}
