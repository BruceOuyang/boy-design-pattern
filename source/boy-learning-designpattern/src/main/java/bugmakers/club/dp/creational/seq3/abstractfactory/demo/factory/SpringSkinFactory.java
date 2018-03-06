package bugmakers.club.dp.creational.seq3.abstractfactory.demo.factory;

import bugmakers.club.dp.creational.seq3.abstractfactory.demo.product.*;

/**
 * @Description: Spring皮肤工厂：具体工厂
 * @Author: Bruce
 * @Datetime: 2018/3/6 11:07
 */
public class SpringSkinFactory implements SkinFactory {
    public Button createButton() {
        return new SpringButton();
    }

    public TextField createTextField() {
        return new SpringTextField();
    }

    public ComboBox createComboBox() {
        return new SpringComboBox();
    }
}
