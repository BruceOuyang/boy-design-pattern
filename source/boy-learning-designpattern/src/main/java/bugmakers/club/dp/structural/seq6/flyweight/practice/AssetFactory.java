package bugmakers.club.dp.structural.seq6.flyweight.practice;

import java.util.Hashtable;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/15 15:33
 */
public class AssetFactory {

    private static AssetFactory factory = new AssetFactory();
    private static Hashtable<String, AbstractAsset> ht;

    public AssetFactory(){
        ht = new Hashtable<String, AbstractAsset>();

        ht.put("image", new ImageAsset());
        ht.put("animation", new AnimationAsset());
        ht.put("video", new VideoAsset());
    }

    public static AssetFactory instance(){
        return factory;
    }

    public AbstractAsset asset(String type){
        return ht.get(type);
    }
}
