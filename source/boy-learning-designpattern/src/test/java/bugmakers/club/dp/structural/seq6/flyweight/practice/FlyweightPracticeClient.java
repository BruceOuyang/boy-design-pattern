package bugmakers.club.dp.structural.seq6.flyweight.practice;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/15 15:37
 */
public class FlyweightPracticeClient {

    public static final String image = "image";
    public static final String animation = "animation";
    public static final String video = "video";

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {

        AssetFactory factory = AssetFactory.instance();

        AbstractAsset i1, i2, a1, a2, v1, v2;

        i1 = factory.asset(image);
        i2 = factory.asset(image);

        a1 = factory.asset(animation);
        a2 = factory.asset(animation);

        v1 = factory.asset(video);
        v2 = factory.asset(video);

        i1.insert(new Position(0, 0), new Size(50, 50));
        i2.insert(new Position(100, 0), new Size(60, 60));

        a1.insert(new Position(0, 100), new Size(50, 50));
        a1.insert(new Position(100, 100), new Size(50, 50));

        v1.insert(new Position(0, 200), new Size(50, 50));
        v1.insert(new Position(100, 200), new Size(50, 50));
    }
}
