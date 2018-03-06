package bugmakers.club.dp.creational.seq3.abstractfactory.demo.product;

import bugmakers.club.dp.creational.seq3.abstractfactory.demo.product.Button;

/**
 * @Description: Summer按钮类：具体产品
 * @Author: Bruce
 * @Datetime: 2018/3/6 10:57
 */
public class SummerButton implements Button {

    public void display() {
        System.out.println("显示浅蓝色按钮");
    }
}
