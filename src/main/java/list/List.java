package list;

/**
 * List
 *
 * @author rhzhou
 * @date 2018/12/25 20:39
 */
public interface List <E>{
    /**
     * 插入元素
     * @param e 所要插入的元素
     * @param index 要插入的位置
     */
    public void insert(E e, int index) throws Exception;

    public void add(E e);
}
