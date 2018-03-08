package bugmakers.club.dp.creational.seq5.prototype.demooptimized.prototypemanager;

/**
 * @Description: 软件需求规格说明书(Software Requirements Specification)类
 * @Author: Bruce
 * @Datetime: 2018/3/8 11:01
 */
public class SoftwareRequirementsSpecification implements OfficialDocument {

    @Override
    public SoftwareRequirementsSpecification clone() {
        try {
            return (SoftwareRequirementsSpecification) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void display() {
        System.out.println("软件需求规格说明书");
    }
}
