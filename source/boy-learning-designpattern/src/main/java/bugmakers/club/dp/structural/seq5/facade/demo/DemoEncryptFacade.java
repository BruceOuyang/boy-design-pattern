package bugmakers.club.dp.structural.seq5.facade.demo;

/**
 * @Description: EncryptFacade：加密外观类，充当外观类
 * @Author: Bruce
 * @Datetime: 2018/3/14 17:57
 */
public class DemoEncryptFacade {

    /**
     * 维持对其他对象的引用
     */
    private DemoFileReader reader;
    private CipherMachine cipher;
    private DemoFileWriter writer;

    public DemoEncryptFacade()
    {
        reader = new DemoFileReader();
        cipher = new CipherMachine();
        writer = new DemoFileWriter();
    }

    /**
     * 调用其他对象的业务方法
     * @param fileNameSrc
     * @param fileNameDes
     */
    public void fileEncrypt(String fileNameSrc, String fileNameDes)
    {
        String plainStr = reader.read(fileNameSrc);
        String encryptStr = cipher.encrypt(plainStr);
        writer.write(encryptStr, fileNameDes);
    }
}
