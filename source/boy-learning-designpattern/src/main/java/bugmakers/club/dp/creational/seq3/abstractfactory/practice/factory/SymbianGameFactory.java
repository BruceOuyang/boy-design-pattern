package bugmakers.club.dp.creational.seq3.abstractfactory.practice.factory;

import bugmakers.club.dp.creational.seq3.abstractfactory.practice.product.InterfaceController;
import bugmakers.club.dp.creational.seq3.abstractfactory.practice.product.OperationController;
import bugmakers.club.dp.creational.seq3.abstractfactory.practice.product.SymbianInterfaceController;
import bugmakers.club.dp.creational.seq3.abstractfactory.practice.product.SymbianOperationController;

/**
 * @Description: 塞班游戏工厂
 * @Author: Bruce
 * @Datetime: 2018/3/6 15:30
 */
public class SymbianGameFactory extends GameFactory {

    @Override
    public InterfaceController createInterfaceController() {
        return new SymbianInterfaceController();
    }

    @Override
    public OperationController createOperationController() {
        return new SymbianOperationController();
    }
}
