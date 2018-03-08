package bugmakers.club.dp.creational.seq5.prototype.demooptimized.prototypemanager;

import java.util.Hashtable;

/**
 * @Description: 原型管理器（使用饿汉式单例实现）
 * @Author: Bruce
 * @Datetime: 2018/3/8 11:05
 */
public class PrototypeManager {

    /**
     * 定义一个Hashtable，用于存储原型对象
     */
    private Hashtable<String, OfficialDocument> ht = new Hashtable<String, OfficialDocument>();

    private static PrototypeManager prototypeManager = new PrototypeManager();

    private PrototypeManager(){
        ht.put("far", new FeasibilityAnalysisReport());
        ht.put("srs", new SoftwareRequirementsSpecification());
    }

    /**
     * 添加一个公文对象
     * @param key
     * @param officialDocument
     */
    public void addOfficialDocument(String key, OfficialDocument officialDocument){
        ht.put(key, officialDocument);
    }

    /**
     * 通过浅克隆获取新的公文对象
     * @param key
     * @return
     */
    public OfficialDocument getOfficialDocument(String key){
        return ht.get(key).clone();
    }

    public static PrototypeManager getPrototypeManager(){
        return prototypeManager;
    }
}
