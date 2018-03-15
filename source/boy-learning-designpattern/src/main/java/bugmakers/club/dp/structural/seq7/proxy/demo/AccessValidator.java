package bugmakers.club.dp.structural.seq7.proxy.demo;

import java.text.MessageFormat;

/**
 * @Description: AccessValidator：身份验证类，业务类，它提供方法Validate()来实现身份验证
 * @Author: Bruce
 * @Datetime: 2018/3/15 17:01
 */
public class AccessValidator {

    public static final String VALID_USER_ID = "admin";
    public static final String MSG_SUCCESS = "{0}登录成功！";
    public static final String MSG_FAILURE = "{0}登录失败！";

    /**
     * 模拟实现登录验证
     * @param userId
     * @return
     */
    public boolean validte(String userId){
        System.out.println("在数据库中验证用户'" + userId + "'是否是合法用户？");
        if (VALID_USER_ID.equals(userId)) {
            System.out.println(MessageFormat.format(MSG_SUCCESS, userId));
            return true;
        }
        else {
            System.out.println(MessageFormat.format(MSG_FAILURE, userId));
            return false;
        }
    }
}
