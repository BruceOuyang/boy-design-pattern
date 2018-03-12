package bugmakers.club.dp.structural.seq3.composite.demo;

/**
 * @Description: 抽象文件类：抽象构件
 * @Author: Bruce
 * @Datetime: 2018/3/12 17:41
 */
public abstract class AbstractFile {

    protected String name;

    public void add(AbstractFile file) {
        System.out.println("对不起，不支持该方法！");
    }

    public void remove(AbstractFile file) {
        System.out.println("对不起，不支持该方法！");
    }

    public AbstractFile getChild(int i) {
        System.out.println("对不起，不支持该方法！");
        return null;
    }

    public abstract void killVirus();
}
