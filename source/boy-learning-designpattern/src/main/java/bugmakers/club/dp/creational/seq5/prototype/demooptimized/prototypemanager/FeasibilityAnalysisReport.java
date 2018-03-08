package bugmakers.club.dp.creational.seq5.prototype.demooptimized.prototypemanager;

/**
 * @Description: 可行性分析报告(Feasibility Analysis Report)类
 * @Author: Bruce
 * @Datetime: 2018/3/8 10:34
 */
public class FeasibilityAnalysisReport implements OfficialDocument {

    @Override
    public OfficialDocument clone() {
        try {
            return (OfficialDocument) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void display() {
        System.out.println("可行性分析报告");
    }
}
