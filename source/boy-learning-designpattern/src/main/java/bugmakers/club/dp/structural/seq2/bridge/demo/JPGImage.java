package bugmakers.club.dp.structural.seq2.bridge.demo;

/**
 * @Description: JPG格式图像：扩充抽象类
 * @Author: Bruce
 * @Datetime: 2018/3/9 17:04
 */
public class JPGImage extends Image {

    /**
     * 模拟解析JPG文件并获得一个像素矩阵对象m
     * @param fileName
     */
    @Override
    public void parseFile(String fileName) {
        Matrix m = new Matrix();
        impl.doPaint(m);
        System.out.println(fileName + "，格式为JPG。");
    }
}
