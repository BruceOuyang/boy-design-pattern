package bugmakers.club.dp.structural.seq5.facade.demo;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/14 18:01
 */
public class FacadeDemoClient {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {
        DemoEncryptFacade ef = new DemoEncryptFacade();
        ef.fileEncrypt("config-repo/structural/seq5/facade/src.txt", "config-repo/structural/seq5/facade/des.txt");
    }
}
