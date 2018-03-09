package bugmakers.club.dp.structural.seq2.bridge.practice.convert;

/**
 * @Description: PDF文件转换器
 * @Author: Bruce
 * @Datetime: 2018/3/9 17:59
 */
public class PdfConvert extends Converter {

    @Override
    public void convert() {

        this.querier.search();

        System.out.println("转成PDF文件");
    }
}
