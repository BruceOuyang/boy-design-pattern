package bugmakers.club.dp.structural.seq2.bridge.demo;

/**
 * @Description: Windows操作系统实现类：具体实现类
 * @Author: Bruce
 * @Datetime: 2018/3/9 17:01
 */
public class WindowsImp implements ImageImpl {

    public void doPaint(Matrix m) {
        /**
         * 调用Windows系统的绘制函数绘制像素矩阵
         */
        System.out.print("在Windows操作系统中显示图像：");
    }
}
