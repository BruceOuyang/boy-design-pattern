package bugmakers.club.dp.behavioral.seq04.iterator.demo;

import java.util.List;

/**
 * @Description: 商品数据类：具体聚合类
 * @Author: Bruce
 * @Datetime: 2018/3/23 10:34
 */
public class ProductList extends AbstractObjectList {

    public ProductList(List<Object> products) {
        super(products);
    }

    /**
     * 实现创建迭代器对象的具体工厂方法
     * @return
     */
    @Override
    public AbstractIterator createIterator() {
        return new ProductIterator(this);
    }
}
