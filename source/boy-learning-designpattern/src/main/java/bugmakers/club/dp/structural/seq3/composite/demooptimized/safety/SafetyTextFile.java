package bugmakers.club.dp.structural.seq3.composite.demooptimized.safety;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/13 10:55
 */
public class SafetyTextFile extends SafetyAbstractFile {

    public SafetyTextFile(String name) {
        super.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("----对文本文件'" + name + "'进行杀毒");
    }
}
