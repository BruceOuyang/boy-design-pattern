package bugmakers.club.dp.structural.seq1.adapter.practice;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/9 14:56
 */
public class AdapterPracticeClient {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {
        EncryptServiceAdapter adapter = new EncryptServiceAdapter();

        DbService dbService = new DbService();

        String data = adapter.encrypt("data");

        dbService.save(data);
    }
}
