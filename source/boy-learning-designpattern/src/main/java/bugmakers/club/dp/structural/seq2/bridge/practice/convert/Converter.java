package bugmakers.club.dp.structural.seq2.bridge.practice.convert;

import bugmakers.club.dp.structural.seq2.bridge.practice.dbservice.DataQuerier;

/**
 * @Description: 数据转换器
 * @Author: Bruce
 * @Datetime: 2018/3/9 17:55
 */
public abstract class Converter {

    protected DataQuerier querier;

    public void setQuerier(DataQuerier querier) {
        this.querier = querier;
    }

    /**
     * 转换
     */
    public abstract void convert();
}
