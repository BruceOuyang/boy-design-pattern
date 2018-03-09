package bugmakers.club.dp.structural.seq1.adapter.practice;

/**
 * @Description: 系统已准备好的数据库存储服务：适配者
 * @Author: Bruce
 * @Datetime: 2018/3/9 14:36
 */
public class DbService {

    public void save(String data) {
        System.out.println("将" + data + "存入数据库");
    }
}
