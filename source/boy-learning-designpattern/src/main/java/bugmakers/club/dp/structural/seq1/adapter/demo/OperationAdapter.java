package bugmakers.club.dp.structural.seq1.adapter.demo;

/**
 * @Description: 操作适配器：适配器
 * @Author: Bruce
 * @Datetime: 2018/3/9 14:06
 */
public class OperationAdapter implements ScoreOperation {

    private QuickSort quickSort;
    private BinarySearch binarySearch;

    public OperationAdapter() {
        quickSort = new QuickSort();
        binarySearch = new BinarySearch();
    }

    public int[] sort(int[] array) {
        return quickSort.quickSort(array);
    }

    public int search(int[] array, int key) {
        return binarySearch.binarySearch(array, key);
    }
}
