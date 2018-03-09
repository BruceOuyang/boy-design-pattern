package bugmakers.club.dp.structural.seq1.adapter.practice;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/9 14:52
 */
public class EncryptServiceAdapter implements EncryptReq {

    private EncryptService encryptService;

    public EncryptServiceAdapter(){
        encryptService = new EncryptService();
    }

    public String encrypt(String data) {
        return encryptService.encryptData(data);
    }
}
