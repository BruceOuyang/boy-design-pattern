package bugmakers.club.dp.structural.seq7.proxy.demo;

import java.text.MessageFormat;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/15 17:30
 */
public class ProxyDemoClient {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {
        Searcher searcher = ProxyXMLUtil.getBean();
        searcher.doSearch("admin", "hello world");
    }

}
