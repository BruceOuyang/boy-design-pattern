package bugmakers.club.dp.structural.seq4.decorator.practice;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/14 14:06
 */
public class EncryptDecorator extends Encryptor {

    private Encryptor encryptor;

    public EncryptDecorator(Encryptor encryptor){
        this.encryptor = encryptor;
    }

    @Override
    public String encrypt(String param) {
        return encryptor.encrypt(param);
    }
}
