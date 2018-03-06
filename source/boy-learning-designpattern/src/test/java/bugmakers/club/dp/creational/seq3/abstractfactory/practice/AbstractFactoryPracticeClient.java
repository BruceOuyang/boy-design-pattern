package bugmakers.club.dp.creational.seq3.abstractfactory.practice;

import bugmakers.club.dp.creational.seq3.abstractfactory.practice.factory.AndroidGameFactory;
import bugmakers.club.dp.creational.seq3.abstractfactory.practice.factory.GameFactory;
import bugmakers.club.dp.creational.seq3.abstractfactory.practice.product.InterfaceController;
import bugmakers.club.dp.creational.seq3.abstractfactory.practice.product.OperationController;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/6 15:33
 */
public class AbstractFactoryPracticeClient {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {

        //
        GameFactory gameFactory = new AndroidGameFactory();
        InterfaceController interfaceController = gameFactory.createInterfaceController();
        OperationController operationController = gameFactory.createOperationController();

        interfaceController.info();
        operationController.info();
    }
}
