package bugmakers.club.dp.creational.seq6.builder.structural;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/8 16:50
 */
public abstract class Builder {

    /**
     * 创建产品对象
     */
    protected  Product product = new Product();

    /**
     * 构建部件A
     */
    public  abstract void buildPartA();

    /**
     * 构建部件B
     */
    public  abstract void buildPartB();

    /**
     * 构建部件C
     */
    public  abstract void buildPartC();

    /**
     * 返回产品对象
     * @return
     */
    public Product getResult() {
        return product;
    }
}
