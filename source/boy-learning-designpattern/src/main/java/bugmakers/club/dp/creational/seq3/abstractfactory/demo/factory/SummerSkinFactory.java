package bugmakers.club.dp.creational.seq3.abstractfactory.demo.factory;

import bugmakers.club.dp.creational.seq3.abstractfactory.demo.product.*;

/**
 * @Description: Summer皮肤工厂：具体工厂
 * @Author: Bruce
 * @Datetime: 2018/3/6 11:09
 */
public class SummerSkinFactory implements SkinFactory {
    public Button createButton() {
        return new SummerButton();
    }

    public TextField createTextField() {
        return new SummerTextField();
    }

    public ComboBox createComboBox() {
        return new SpringComboBox();
    }
}
