package bugmakers.club.dp.structural.seq3.composite.structural.objectoriented;

/**
 * @Description: 为了突出核心框架代码，我们对杀毒过程的实现进行了大量简化
 * @Author: Bruce
 * @Datetime: 2018/3/12 14:36
 */
public class OoImgFile extends AbstractOoFile {

    public OoImgFile(String name){
        super.name = name;
    }

    @Override
    public void killVirus() {
        //简化代码，模拟杀毒
        System.out.println("----对图像文件'" + super.name + "'进行杀毒");
    }
}
