package bugmakers.club.dp.structural.seq5.facade.demooptimized;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/15 10:06
 */
public class FacadeDemooptimizedClient {

    private static final String fileNameSrc = "config-repo/structural/seq5/facade/src.txt";
    public static final String fileNameDes = "config-repo/structural/seq5/facade/des.txt";

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {

        // 针对抽象外观类编程
        AbstractEncryptFacade facade = FacadeXMLUtil.getBean();

        facade.fileEncrypt(fileNameSrc, fileNameDes);
    }
}
