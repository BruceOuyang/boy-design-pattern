package bugmakers.club.dp.structural.seq4.decorator.practice;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/14 14:28
 */
public class ShiftEncryptor extends Encryptor {

    @Override
    public String encrypt(String param) {
        System.out.println("位移加密：" + param + " --------------------> " + "[位移加密]" + param);
        return "[位移加密]" + param;
    }
}
