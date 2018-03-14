package bugmakers.club.dp.structural.seq4.decorator.practice;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/14 14:24
 */
public class ModEncryptDecorator extends EncryptDecorator {

    public ModEncryptDecorator(Encryptor encryptor) {
        super(encryptor);
    }

    @Override
    public String encrypt(String param) {
        return mod(super.encrypt(param));
    }

    public String mod(String param){
        System.out.println("求模加密：" + param + " --------------------> " + "[求模加密]" + param);
        return "[求模加密]" + param;
    }
}
