package bugmakers.club.dp.structural.seq5.facade.demo;

/**
 * @Description: CipherMachine：数据加密类，充当子系统类
 * @Author: Bruce
 * @Datetime: 2018/3/14 17:48
 */
public class CipherMachine {

    public String encrypt(String plainText)
    {
        System.out.println("数据加密，将明文转换为密文：");
        String es = "";
        char[] chars = plainText.toCharArray();
        for(char ch : chars)
        {
            String c = String.valueOf(ch % 7);
            es += c;
        }
        System.out.println(es);
        return es;
    }

}
