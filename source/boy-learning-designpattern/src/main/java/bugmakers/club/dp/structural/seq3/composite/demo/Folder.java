package bugmakers.club.dp.structural.seq3.composite.demo;

import java.util.ArrayList;

/**
 * @Description: 文件夹类：容器构件
 * @Author: Bruce
 * @Datetime: 2018/3/12 17:48
 */
public class Folder extends AbstractFile {

    /**
     * 定义集合fileList，用于存储AbstractFile类型的成员
     */
    private ArrayList<AbstractFile> fileList=new ArrayList<AbstractFile>();

    public Folder(String name) {
        this.name = name;
    }

    @Override
    public void add(AbstractFile file) {
        fileList.add(file);
    }

    @Override
    public void remove(AbstractFile file) {
        fileList.remove(file);
    }

    @Override
    public AbstractFile getChild(int i) {
        return fileList.get(i);
    }

    @Override
    public void killVirus() {

        //模拟杀毒
        System.out.println("****对文件夹'" + name + "'进行杀毒");

        //递归调用成员构件的killVirus()方法
        for(Object obj : fileList) {
            ((AbstractFile)obj).killVirus();
        }
    }
}
