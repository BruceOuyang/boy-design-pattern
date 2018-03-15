package bugmakers.club.dp.structural.seq7.proxy.demo;

/**
 * @Description: ProxySearcher：代理查询类，充当代理主题角色，它是查询代理，维持了对RealSearcher对象、AccessValidator对象和Logger对象的引用
 * @Author: Bruce
 * @Datetime: 2018/3/15 17:11
 */
public class ProxySearcher implements Searcher {

    /**
     * 维持一个对真实主题的引用
     */
    private RealSearcher searcher = new RealSearcher();
    private AccessValidator validator;
    private Logger logger;

    public String doSearch(String userId, String keyword) {
        String result = null;

        // 用户非法校验
        if(this.validate(userId)){

            // 实际查询
            result = searcher.doSearch(userId, keyword);

            // 记录日志
            this.log(userId);
        }
        return result;
    }

    public boolean validate(String userId){
        validator = new AccessValidator();
        return validator.validte(userId);
    }

    public void log(String userId){
        logger = new Logger();
        logger.log(userId);
    }
}
