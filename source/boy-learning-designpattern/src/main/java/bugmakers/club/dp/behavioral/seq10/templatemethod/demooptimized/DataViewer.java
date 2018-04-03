package bugmakers.club.dp.behavioral.seq10.templatemethod.demooptimized;

/**
 * @Description: 抽象类
 * @Author: Bruce
 * @Datetime: 2018/4/3 11:18
 */
public abstract class DataViewer {

    /**
     * 抽象方法：获取数据
     */
    public abstract void getData();

    /**
     * 具体方法：转换数据
     */
    public void convertData(){
        System.out.println("将数据转换为XML格式。");
    }

    /**
     * 抽象方法：显示数据
     */
    public abstract void displayData();

    /**
     * 钩子方法：判断是否为XML格式的数据
     * @return
     */
    public boolean isNotXMLData(){
        return true;
    }

    /**
     * 模板方法
     */
    public void process(){
        getData();
        if(isNotXMLData()){
            convertData();
        }
        displayData();
    }
}
