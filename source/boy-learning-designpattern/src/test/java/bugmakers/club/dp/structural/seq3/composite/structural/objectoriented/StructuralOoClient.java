package bugmakers.club.dp.structural.seq3.composite.structural.objectoriented;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/12 15:50
 */
public class StructuralOoClient {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {
        OoFolder folder1,folder2,folder3;
        folder1 = new OoFolder("Sunny的资料");
        folder2 = new OoFolder("图像文件");
        folder3 = new OoFolder("文本文件");

        OoImgFile image1,image2;
        image1 = new OoImgFile("小龙女.jpg");
        image2 = new OoImgFile("张无忌.gif");

        OoTxtFile text1,text2;
        text1 = new OoTxtFile("九阴真经.txt");
        text2 = new OoTxtFile("葵花宝典.doc");

        folder2.addImg(image1);
        folder2.addImg(image2);
        folder3.addTxt(text1);
        folder3.addTxt(text2);
        folder1.addFolder(folder2);
        folder1.addFolder(folder3);

        folder1.killVirus();
    }
}
