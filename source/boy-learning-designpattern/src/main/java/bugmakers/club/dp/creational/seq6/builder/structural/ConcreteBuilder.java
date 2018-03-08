package bugmakers.club.dp.creational.seq6.builder.structural;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/8 16:54
 */
public class ConcreteBuilder extends Builder {

    @Override
    public void buildPartA() {
        System.out.println("构建模块A");
    }

    @Override
    public void buildPartB() {
        System.out.println("构建模块B");
    }

    @Override
    public void buildPartC() {
        System.out.println("构建模块C");
    }
}
