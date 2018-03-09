package bugmakers.club.dp.structural.seq2.bridge.practice;

import bugmakers.club.dp.structural.seq2.bridge.practice.convert.Converter;
import bugmakers.club.dp.structural.seq2.bridge.practice.convert.PdfConvert;
import bugmakers.club.dp.structural.seq2.bridge.practice.dbservice.DataQuerier;
import bugmakers.club.dp.structural.seq2.bridge.practice.dbservice.MysqlDataQuerier;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/9 18:13
 */
public class BridgePracticeClient {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {
        DataQuerier querier = new MysqlDataQuerier();

        Converter converter = new PdfConvert();
        converter.setQuerier(querier);

        converter.convert();
    }
}
