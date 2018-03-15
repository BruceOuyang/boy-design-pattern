package bugmakers.club.dp.structural.seq5.facade.demooptimized;

import bugmakers.club.dp.structural.seq5.facade.demo.DemoFileReader;
import bugmakers.club.dp.structural.seq5.facade.demo.DemoFileWriter;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/15 9:29
 */
public class NewEncryptFacade extends AbstractEncryptFacade {

    private DemoFileReader reader;
    private DemoFileWriter writer;
    private NewCipherMachine cipherMachine;

    public NewEncryptFacade() {
        reader = new DemoFileReader();
        writer = new DemoFileWriter();
        cipherMachine = new NewCipherMachine();
    }

    @Override
    public void fileEncrypt(String fileNameSrc, String fileNameDes) {

        String val = reader.read(fileNameSrc);
        String encryptVal = cipherMachine.encrypt(val);
        writer.write(encryptVal, fileNameDes);
    }
}
