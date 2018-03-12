package bugmakers.club.dp.structural.seq3.composite.demo.objectoriented;

/**
 * @Description: 文本文件
 * @Author: Bruce
 * @Datetime: 2018/3/12 15:08
 */
public class OoTxtFile extends AbstractOoFile {

    public OoTxtFile(String name) {
        super.name = name;
    }

    @Override
    public void killVirus() {
        //简化代码，模拟杀毒
        System.out.println("----对文本文件'" + name + "'进行杀毒");
    }
}
