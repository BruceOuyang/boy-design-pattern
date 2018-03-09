package bugmakers.club.dp.structural.seq2.bridge.demooptimized.datacollector.adapter;

import bugmakers.club.dp.structural.seq2.bridge.demooptimized.thirdapi.ExcelApi;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/9 17:33
 */
public class ExcelDataCollectorAdapter implements CollectExcelDataReq {

    private ExcelApi excelApi;

    public ExcelDataCollectorAdapter(){
        excelApi = new ExcelApi();
    }

    public String collectDataFromExcel() {
        return excelApi.readData();
    }
}
