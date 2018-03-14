package bugmakers.club.dp.structural.seq5.facade.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Description: FileReader：文件读取类，充当子系统类。
 * @Author: Bruce
 * @Datetime: 2018/3/14 17:26
 */
public class DemoFileReader {

    public String read(String fileNameSrc)
    {
        System.out.println("读取文件，获取明文：");
        FileInputStream fs = null;
        StringBuilder sb = new StringBuilder();
        try
        {
            fs = new FileInputStream(fileNameSrc);
            int data;
            while((data = fs.read())!= -1)
            {
                sb = sb.append((char)data);
            }
            fs.close();
            System.out.println(sb.toString());
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件操作错误！");
        }
        return sb.toString();
    }
}
