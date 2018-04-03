package bugmakers.club.dp.behavioral.seq11.visitor.demo;

import bugmakers.club.dp.util.BoyXMLUtil;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/4/3 17:14
 */
public class VisitorXMLUtil {

    public static final String VISITOR_CONFIG = "config-repo/behavioral/seq11/visitor/visitor-pattern.xml";

    public static Object getBean(){
        return BoyXMLUtil.getBean(VISITOR_CONFIG);
    }
}
