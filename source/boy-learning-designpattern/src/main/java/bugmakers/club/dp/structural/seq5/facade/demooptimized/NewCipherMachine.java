package bugmakers.club.dp.structural.seq5.facade.demooptimized;

/**
 * @Description: 基于移位运算的加密类
 * @Author: Bruce
 * @Datetime: 2018/3/14 18:09
 */
public class NewCipherMachine {

    public String encrypt(String plainText)
    {
        System.out.println("数据加密，将明文转换为密文：");
        String es = "";
        //设置密钥，移位数为10
        int key = 10;
        char[] chars = plainText.toCharArray();
        for(char ch : chars)
        {
            int temp = ch;

            //小写字母移位  
            if (ch >= 'a' && ch <= 'z') {
                temp += key % 26;
                if(temp > 122){
                    temp -= 26;
                }
                if(temp < 97){
                    temp += 26;
                }
            }

            //大写字母移位  
            if (ch >= 'A' && ch <= 'Z') {
                temp += key % 26;
                if(temp > 90){
                    temp -= 26;
                }
                if(temp < 65){
                    temp += 26;
                }
            }
            es += String.valueOf(temp);
        }
        System.out.println(es);
        return es;
    }
}
