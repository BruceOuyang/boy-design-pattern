package bugmakers.club.dp.creational.seq6.builder.structural;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/8 16:57
 */
public class BuilderStructuralClient {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {
        ConcreteBuilder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        Product product = director.construct();
    }
}
