package bugmakers.club.dp.structural.seq3.composite.demo;

/**
 * @Description: 图像文件类：叶子构件
 * @Author: Bruce
 * @Datetime: 2018/3/12 17:43
 */
public class ImageFile extends AbstractFile {

    public ImageFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        //模拟杀毒
        System.out.println("----对图像文件'" + name + "'进行杀毒");
    }
}
