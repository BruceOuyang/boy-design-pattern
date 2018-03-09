package bugmakers.club.dp.structural.seq1.adapter.demo;

/**
 * @Description: 二分法查找：适配者
 * @Author: Bruce
 * @Datetime: 2018/3/9 14:02
 */
public class BinarySearch {

    /**
     *
     * @param array
     * @param key
     * @return
     */
    public int binarySearch(int array[],int key) {
        int low = 0;
        int high = array.length -1;
        while(low <= high) {
            int mid = (low + high) / 2;
            int midVal = array[mid];
            if(midVal < key) {
                low = mid +1;
            }
            else if (midVal > key) {
                high = mid -1;
            }
            else {
                //找到元素返回1
                return 1;
            }
        }
        //未找到元素返回-1
        return -1;
    }
}
