package bugmakers.club.dp.creational.seq2.factorymethod.practice;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/5 17:57
 */
public class FactoryMethodPracticeClient {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {
        ImgReaderFactory imgReaderFactory = new JpgImgReaderFactory();
        ImgReader imgReader = imgReaderFactory.createImgReader();
        imgReader.readImg();
    }
}
