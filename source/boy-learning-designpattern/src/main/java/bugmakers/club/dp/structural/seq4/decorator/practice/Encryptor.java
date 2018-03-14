package bugmakers.club.dp.structural.seq4.decorator.practice;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/14 14:05
 */
public abstract class Encryptor {

    /**
     * 对入参进行加密处理，返回加密字符串
     * @param param
     * @return
     */
    public abstract String encrypt(String param);
}
