package bugmakers.club.dp.behavioral.seq10.templatemethod.demo;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/4/3 10:53
 */
public class TemplatemethodDemoClient {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {
        Account account = TemplatemethodXMLUtil.getBean();
        account.handle("bruce", "124356");
    }
}
