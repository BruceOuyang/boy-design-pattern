package bugmakers.club.dp.creational.seq6.builder.structural;

/**
 * @Description: 指挥者
 * @Author: Bruce
 * @Datetime: 2018/3/8 16:52
 */
public class Director {

    private  Builder builder;

    public  Director(Builder builder) {
        this.builder=builder;
    }

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    /**
     * 产品构建与组装方法
     * @return
     */
    public Product construct() {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getResult();
    }
}
