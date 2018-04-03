package bugmakers.club.dp.behavioral.seq10.templatemethod.demooptimized;

/**
 * @Description: 具体子类 - 用于显示XML格式数据
 * @Author: Bruce
 * @Datetime: 2018/4/3 11:21
 */
public class XMLDataViewer extends DataViewer {

    @Override
    public void getData() {
        System.out.println("从XML文件中获取数据。");
    }

    @Override
    public void displayData() {
        System.out.println("以柱状图显示数据。");
    }

    @Override
    public boolean isNotXMLData() {
        return false;
    }
}
