package bugmakers.club.dp.structural.seq3.composite.demooptimized.safety;

/**
 * @Description: 在抽象构件AbstractFile中不声明任何用于访问和管理成员构件的方法
 * @Author: Bruce
 * @Datetime: 2018/3/13 10:53
 */
public abstract class SafetyAbstractFile {

    protected String name;

    /**
     * 杀毒
     */
    public abstract void killVirus();
}
