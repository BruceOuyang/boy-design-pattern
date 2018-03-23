package bugmakers.club.dp.behavioral.seq04.iterator.demooptimized.inneriterator;

import bugmakers.club.dp.behavioral.seq04.iterator.demo.AbstractIterator;
import bugmakers.club.dp.behavioral.seq04.iterator.demo.AbstractObjectList;

import java.util.List;

/**
 * @Description: 商品数据类：具体聚合类
 * @Author: Bruce
 * @Datetime: 2018/3/23 11:09
 */
public class ProductList extends AbstractObjectList {

    public ProductList(List products) {
        super(products);
    }

    @Override
    public AbstractIterator createIterator() {
        return new ProductIterator();
    }

    /**
     * 商品迭代器：具体迭代器，内部类实现
     */
    private class ProductIterator implements AbstractIterator {
        private int cursor1;
        private int cursor2;

        public ProductIterator() {
            cursor1 = 0;
            cursor2 = objects.size() -1;
        }

        public void next() {
            if(cursor1 < objects.size()) {
                cursor1++;
            }
        }

        public boolean isLast() {
            return (cursor1 == objects.size());
        }

        public void previous() {
            if(cursor2 > -1) {
                cursor2--;
            }
        }

        public boolean isFirst() {
            return (cursor2 == -1);
        }

        public Object getNextItem() {
            return objects.get(cursor1);
        }

        public Object getPreviousItem() {
            return objects.get(cursor2);
        }
    }
}
