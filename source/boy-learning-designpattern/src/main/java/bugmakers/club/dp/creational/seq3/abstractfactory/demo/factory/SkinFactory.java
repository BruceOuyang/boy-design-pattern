package bugmakers.club.dp.creational.seq3.abstractfactory.demo.factory;

import bugmakers.club.dp.creational.seq3.abstractfactory.demo.product.Button;
import bugmakers.club.dp.creational.seq3.abstractfactory.demo.product.ComboBox;
import bugmakers.club.dp.creational.seq3.abstractfactory.demo.product.TextField;

/**
 * @Description: 界面皮肤工厂接口：抽象工厂
 * @Author: Bruce
 * @Datetime: 2018/3/6 11:04
 */
public interface SkinFactory {

    /**
     * 创建按钮
     * @return
     */
    Button createButton();

    /**
     * 创建文本框
     * @return
     */
    TextField createTextField();

    /**
     * 创建组合框
     * @return
     */
    ComboBox createComboBox();
}
