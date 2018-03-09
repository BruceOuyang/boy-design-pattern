package bugmakers.club.dp.structural.seq2.bridge.demo;

import bugmakers.club.dp.structural.seq2.bridge.demooptimized.BridgeXMLUtil;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/9 17:11
 */
public class BridgeDemoClient {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {
        Image image;
        ImageImpl imp;

//        image = (Image) BridgeXMLUtil.getBean("image");
//        imp = (ImageImpl)BridgeXMLUtil.getBean("os");

        image = new JPGImage();
        imp = new WindowsImp();

        image.setImpl(imp);
        image.parseFile("毕业照");
    }
}
