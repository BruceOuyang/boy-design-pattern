package bugmakers.club.dp.structural.seq3.composite.demooptimized.safety;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/13 11:00
 */
public class SafetyFolder extends SafetyAbstractFile {

    private ArrayList<SafetyAbstractFile> list = new ArrayList<SafetyAbstractFile>();

    public void add(SafetyAbstractFile file) {
        list.add(file);
    }

    public void remove(SafetyAbstractFile file) {
        list.remove(file);
    }

    public SafetyAbstractFile get(int i) {
        return list.get(i);
    }

    @Override
    public void killVirus() {
        for(SafetyAbstractFile file : list) {
            file.killVirus();
        }
    }
}
