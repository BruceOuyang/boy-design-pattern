package bugmakers.club.dp.creational.seq2.factorymethod.practice;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/5 17:55
 */
public class GifImgReaderFactory implements ImgReaderFactory {

    public ImgReader createImgReader() {
        return new GifImgReader();
    }
}
