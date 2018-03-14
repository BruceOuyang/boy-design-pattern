package bugmakers.club.dp.structural.seq4.decorator.practice;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/14 14:25
 */
public class DecoratorPracticeDemo {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {
        Encryptor encryptor, reverseOutputEncryptor, modEncrypter;

        encryptor = new ShiftEncryptor();

        reverseOutputEncryptor = new ReverseOutputEncryptDecorator(encryptor);

        modEncrypter = new ModEncryptDecorator(reverseOutputEncryptor);

        String encryptVal = modEncrypter.encrypt("HelloWorld");

        System.out.println("\n加密结果：");
        System.out.println(encryptVal);
    }
}
