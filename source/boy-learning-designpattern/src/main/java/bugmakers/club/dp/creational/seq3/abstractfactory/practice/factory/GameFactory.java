package bugmakers.club.dp.creational.seq3.abstractfactory.practice.factory;

import bugmakers.club.dp.creational.seq3.abstractfactory.practice.product.InterfaceController;
import bugmakers.club.dp.creational.seq3.abstractfactory.practice.product.OperationController;

/**
 * @Description: 游戏工厂 ： 抽象工厂
 * @Author: Bruce
 * @Datetime: 2018/3/6 15:02
 */
public abstract class GameFactory {

    /**
     * 创建游戏界面控制器
     * @return
     */
    public abstract InterfaceController createInterfaceController();

    /**
     * 创建游戏操作控制器
     * @return
     */
    public abstract OperationController createOperationController();
}
