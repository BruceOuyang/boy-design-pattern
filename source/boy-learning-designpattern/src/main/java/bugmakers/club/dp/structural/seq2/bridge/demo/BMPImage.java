package bugmakers.club.dp.structural.seq2.bridge.demo;

/**
 * @Description: BMP格式图像：扩充抽象类
 * @Author: Bruce
 * @Datetime: 2018/3/9 17:07
 */
public class BMPImage extends Image {

    /**
     * 模拟解析BMP文件并获得一个像素矩阵对象m
     * @param fileName
     */
    @Override
    public void parseFile(String fileName) {
        Matrix m = new Matrix();
        this.impl.doPaint(m);
        System.out.println(fileName + "，格式为BMP。");
    }
}
