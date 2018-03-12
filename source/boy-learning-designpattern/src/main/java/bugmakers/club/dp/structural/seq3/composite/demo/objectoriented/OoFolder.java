package bugmakers.club.dp.structural.seq3.composite.demo.objectoriented;

import java.util.ArrayList;

/**
 * @Description: 文件夹
 * @Author: Bruce
 * @Datetime: 2018/3/12 15:11
 */
public class OoFolder extends AbstractOoFile {

    /**
     * 定义集合folderList，用于存储OoFolder类型的成员
     */
    private ArrayList<OoFolder> folderList = new ArrayList<OoFolder>();

    /**
     * imgList，用于存储OoImgFile类型的成员
     */
    private ArrayList<OoImgFile> imgList = new ArrayList<OoImgFile>();

    /**
     * 定义集合folderList，用于存储OoTxtFile类型的成员
     */
    private ArrayList<OoTxtFile> txtList = new ArrayList<OoTxtFile>();


    /**
     * folderList数据维护
     */
    public void addFolder(OoFolder folder) {
        this.folderList.add(folder);
    }
    public void removeFolder(OoFolder folder) {
        this.folderList.remove(folder);
    }
    public OoFolder getChildFolder(int i) {
        return this.folderList.get(i);
    }


    /**
     * imgList数据维护
     */
    public void addImg(OoImgFile img) {
        this.imgList.add(img);
    }
    public void removeImg(OoImgFile folder) {
        this.imgList.remove(folder);
    }
    public OoImgFile getChildImg(int i) {
        return this.imgList.get(i);
    }


    /**
     * txtList数据维护
     */
    public void addTxt(OoTxtFile txt) {
        this.txtList.add(txt);
    }
    public void removeFolder(OoTxtFile folder) {
        this.txtList.remove(folder);
    }
    public OoTxtFile getChildTxt(int i) {
        return this.txtList.get(i);
    }

    /**
     * 构造函数
     * @param name
     */
    public OoFolder(String name){
        super.name = name;
    }

    /**
     * 模拟杀毒
     */
    @Override
    public void killVirus() {

        System.out.println("****对文件夹'" + super.name + "'进行杀毒");

        for(OoFolder folder : folderList){
            folder.killVirus();
        }

        for(OoImgFile img : imgList){
            img.killVirus();
        }

        for(OoTxtFile txt : txtList){
            txt.killVirus();
        }
    }
}
