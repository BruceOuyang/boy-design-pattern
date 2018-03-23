package bugmakers.club.dp.behavioral.seq04.iterator.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 商品迭代器：具体迭代器
 * @Author: Bruce
 * @Datetime: 2018/3/23 10:37
 */
public class ProductPageIterator implements AbstractIterator {

    private ProductPageList productList;

    private List products;

    /**
     * 正向遍历游标
     */
    private int cursor1;

    /**
     * 逆向遍历游标
     */
    private int cursor2;

    public ProductPageIterator(ProductPageList productList) {
        this.productList = productList;
        this.products = productList.getObjects();

        // 设置正向遍历游标的初始值
        cursor1 = 0;

        // 设置逆向遍历游标的初始值
        cursor2 = products.size() - 1;
    }

    public void next() {
        if(cursor1 < products.size()){
            cursor1++;
        }
    }

    public boolean isLast() {
        return cursor1 == products.size();
    }

    public void previous() {
        if(cursor2 > -1){
            cursor2--;
        }
    }

    public boolean isFirst() {
        return cursor2 == -1;
    }

    public Object getNextItem() {
        return products.get(cursor1);
    }

    public List getNextPage(int size) {
        if(size <= 0){
            return null;
        }
        List result = new ArrayList();
        while(cursor1 <= size - 1){
            result.add(getNextItem());
            next();
        }

        return result;
    }

    public Object getPreviousItem() {
        return products.get(cursor2);
    }
}
