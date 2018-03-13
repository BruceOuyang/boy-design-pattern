package bugmakers.club.dp.structural.seq3.composite.demooptimized.clarify;

import bugmakers.club.dp.structural.seq3.composite.demo.AbstractFile;

/**
 * @Description: 将叶子构件的add()、remove()等方法的实现代码移至AbstractFile类中，由AbstractFile提供统一的默认实现
 * @Author: Bruce
 * @Datetime: 2018/3/13 10:50
 */
public abstract class ClarifyAbstractFile {

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
