package bugmakers.club.dp.structural.seq7.proxy.demo;

import java.text.MessageFormat;

/**
 * @Description: RealSearcher：具体查询类，充当真实主题角色，它实现查询功能，提供方法DoSearch()来查询信息
 * @Author: Bruce
 * @Datetime: 2018/3/15 17:09
 */
public class RealSearcher implements Searcher {

    /**
     * 模拟查询商务信息
     * @param userId
     * @param keyword
     * @return
     */
    public String doSearch(String userId, String keyword) {
        System.out.println(MessageFormat.format("用户{0}使用关键词{1}查询商务信息！",userId,keyword));
        return "返回具体内容";
    }
}
