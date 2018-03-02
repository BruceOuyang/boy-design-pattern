package bugmakers.club.dp.creational.seq1.simplefactory.practice;

import bugmakers.club.dp.creational.seq1.simplefactory.demooptimized.SimpleFactoryXMLUtil;

/**
 * @Description: 简单工程练习题客户端
 * @Author: Bruce
 * @Datetime: 2018/3/2 13:46
 */
public class SimpleFactoryPracticeClient {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {
        Shape shape;
        shape = ShapeFactory.createShape(SimpleFactoryXMLUtil.getShapeType());
        shape.draw();
        shape.erase();
    }
}
