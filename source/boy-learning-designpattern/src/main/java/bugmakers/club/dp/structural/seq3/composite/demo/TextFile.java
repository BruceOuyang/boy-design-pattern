package bugmakers.club.dp.structural.seq3.composite.demo;

/**
 * @Description: 文本文件类：叶子构件
 * @Author: Bruce
 * @Datetime: 2018/3/12 17:45
 */
public class TextFile extends AbstractFile {

    public TextFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        //模拟杀毒
        System.out.println("----对文本文件'" + name + "'进行杀毒");
    }
}
