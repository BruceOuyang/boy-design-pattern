package bugmakers.club.dp.structural.seq4.decorator.practice;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/14 14:13
 */
public class ReverseOutputEncryptDecorator extends EncryptDecorator {

    public ReverseOutputEncryptDecorator(Encryptor encryptor) {
        super(encryptor);
    }

    @Override
    public String encrypt(String param) {
        return reverseOutputEncrypt(super.encrypt(param));
    }

    public String reverseOutputEncrypt(String param){
        System.out.println("逆向输出加密：" + param + " --------------------> " + "[逆向输出加密]" + param);
        return "[逆向输出加密]" + param;
    }
}
