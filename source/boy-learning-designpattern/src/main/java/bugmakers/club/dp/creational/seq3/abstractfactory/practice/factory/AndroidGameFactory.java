package bugmakers.club.dp.creational.seq3.abstractfactory.practice.factory;

import bugmakers.club.dp.creational.seq3.abstractfactory.practice.product.AndroidInterfaceController;
import bugmakers.club.dp.creational.seq3.abstractfactory.practice.product.AndroidOperationController;
import bugmakers.club.dp.creational.seq3.abstractfactory.practice.product.InterfaceController;
import bugmakers.club.dp.creational.seq3.abstractfactory.practice.product.OperationController;

/**
 * @Description: Android游戏工厂
 * @Author: Bruce
 * @Datetime: 2018/3/6 15:31
 */
public class AndroidGameFactory extends GameFactory {

    @Override
    public InterfaceController createInterfaceController() {
        return new AndroidInterfaceController();
    }

    @Override
    public OperationController createOperationController() {
        return new AndroidOperationController();
    }
}
