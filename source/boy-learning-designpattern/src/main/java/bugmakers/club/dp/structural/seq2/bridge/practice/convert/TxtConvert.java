package bugmakers.club.dp.structural.seq2.bridge.practice.convert;

/**
 * @Description: 文本文件转换器
 * @Author: Bruce
 * @Datetime: 2018/3/9 17:57
 */
public class TxtConvert extends Converter {

    @Override
    public void convert() {
        this.querier.search();
        System.out.println("转成文本文件");
    }
}
