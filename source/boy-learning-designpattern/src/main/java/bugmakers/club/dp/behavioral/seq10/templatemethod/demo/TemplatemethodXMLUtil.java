package bugmakers.club.dp.behavioral.seq10.templatemethod.demo;

import bugmakers.club.dp.util.BoyXMLUtil;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/4/3 10:50
 */
public class TemplatemethodXMLUtil {

    public static final String TEMPLATE_METHOD_CONFIG = "config-repo/behavioral/seq10/templatemethod/template-method-pattern.xml";

    public static Account getBean(){
        return (Account) BoyXMLUtil.getBean(TEMPLATE_METHOD_CONFIG);
    }
}
