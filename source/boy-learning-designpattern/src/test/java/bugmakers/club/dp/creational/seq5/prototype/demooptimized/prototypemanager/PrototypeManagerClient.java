package bugmakers.club.dp.creational.seq5.prototype.demooptimized.prototypemanager;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/8 11:32
 */
public class PrototypeManagerClient {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {
        PrototypeManager pm = PrototypeManager.getPrototypeManager();
        OfficialDocument  doc1,doc2,doc3,doc4;

        doc1  = pm.getOfficialDocument("far");
        doc1.display();
        doc2  = pm.getOfficialDocument("far");
        doc2.display();
        System.out.println(doc1  == doc2);

        doc3  = pm.getOfficialDocument("srs");
        doc3.display();
        doc4  = pm.getOfficialDocument("srs");
        doc4.display();
        System.out.println(doc3  == doc4);
    }
}
