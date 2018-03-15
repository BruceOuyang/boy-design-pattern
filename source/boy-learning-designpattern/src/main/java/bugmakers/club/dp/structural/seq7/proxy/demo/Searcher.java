package bugmakers.club.dp.structural.seq7.proxy.demo;

/**
 * @Description: Searcher：抽象查询类，充当抽象主题角色，它声明了DoSearch()方法
 * @Author: Bruce
 * @Datetime: 2018/3/15 17:08
 */
public interface Searcher {

    String doSearch(String userId, String keyword);
}
