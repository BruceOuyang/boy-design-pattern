package bugmakers.club.dp.structural.seq2.bridge.demo;

/**
 * @Description: 抽象图像类：抽象类
 * @Author: Bruce
 * @Datetime: 2018/3/9 16:59
 */
public abstract class Image {

    protected ImageImpl impl;

    public void setImpl(ImageImpl impl){
        this.impl = impl;
    }

    public abstract void parseFile(String fileName);
}
