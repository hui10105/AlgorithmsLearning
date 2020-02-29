package sorts;

/**
 * Sorts
 *
 * @author rhzhou
 * @date 2020/2/27 21:18
 */
public class Sorts {
    /**
     * 插入排序
     * 插入排序相比冒泡排序的优点是，冒泡排序的比较次数是固定的，而插入排序的比较必然<=冒泡的比较
     * 越是较有序的数组，插入排序比较次数越少
     * @param a
     * @param <AnyType>
     */
    public static <AnyType extends Comparable<? super AnyType>> void insertionSort(AnyType[] a){
        int j;
        for(int p=1; p<a.length; p++){ // n-1次循环
            AnyType tmp = a[p];
            for(j=p; j>0 && tmp.compareTo(a[j-1]) < 0; j--){ // 最差比较和交换 1+2+...+n-1=n*(n-1)/2=O(n^2/2)
                a[j] = a[j-1];
            }
            a[j] = tmp;
        }
    }
    /**
     * 希尔排序
     * 当前gapk=N/2^k
     * 一个更好的希尔增量取值为gap=2^k -1
     */
    public static <AnyType extends Comparable<? super AnyType>> void shellSort(AnyType[] a){
        int j;
        for(int gap = a.length/2; gap > 0; gap/=2){
            for(int i = gap; i<a.length; i++){
                AnyType tmp = a[i];
                for(j = i; j>=gap && tmp.compareTo(a[j-gap])<0;j-=gap){
                    a[j] = a[j-gap];
                }
                a[j] = tmp;
            }
        }
    }

    /**
     * 冒泡排序
     * @param a
     * @param <AnyType>
     */
    public static <AnyType extends Comparable<? super AnyType>> void bubbleSort(AnyType[] a){
        int n = a.length;
        for(int i=0; i<n-1; i++){ //n-1次
            for(int j=0; j<n-i-1; j++){ // n-1 + n-1 + ... +1 = n*(n-1)/2
                if(a[j].compareTo(a[j+1])>0){
                    AnyType temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }
}
