package bugmakers.club.dp.creational.seq3.abstractfactory.practice.factory;

import bugmakers.club.dp.creational.seq3.abstractfactory.practice.product.InterfaceController;
import bugmakers.club.dp.creational.seq3.abstractfactory.practice.product.OperationController;
import bugmakers.club.dp.creational.seq3.abstractfactory.practice.product.WPhoneInterfaceController;
import bugmakers.club.dp.creational.seq3.abstractfactory.practice.product.WPhoneOperationController;

/**
 * @Description: WindowsPhone游戏工厂
 * @Author: Bruce
 * @Datetime: 2018/3/6 15:31
 */
public class WPhoneGameFactory extends GameFactory {

    @Override
    public InterfaceController createInterfaceController() {
        return new WPhoneInterfaceController();
    }

    @Override
    public OperationController createOperationController() {
        return new WPhoneOperationController();
    }
}
