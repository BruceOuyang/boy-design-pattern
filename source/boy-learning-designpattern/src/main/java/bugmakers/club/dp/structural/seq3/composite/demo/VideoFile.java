package bugmakers.club.dp.structural.seq3.composite.demo;

/**
 * @Description: 视频文件类：叶子构件
 * @Author: Bruce
 * @Datetime: 2018/3/12 17:46
 */
public class VideoFile extends AbstractFile {

    public VideoFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        //模拟杀毒
        System.out.println("----对视频文件'" + name + "'进行杀毒");
    }
}
