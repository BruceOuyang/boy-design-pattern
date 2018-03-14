package bugmakers.club.dp.structural.seq5.facade.demo;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Description: FileWriter：文件保存类，充当子系统类
 * @Author: Bruce
 * @Datetime: 2018/3/14 17:54
 */
public class DemoFileWriter {

    public void write(String encryptStr,String fileNameDes)
    {
        System.out.println("保存密文，写入文件。");
        FileOutputStream fs = null;
        try
        {
            fs = new FileOutputStream(fileNameDes);
            byte[] str = encryptStr.getBytes();
            fs.write(str,0,str.length);
            fs.flush();
            fs.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
            System.out.println("文件操作错误！");
        }
    }
}
