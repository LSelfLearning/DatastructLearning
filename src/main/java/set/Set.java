package set;

public interface Set<E> {
    //不能添加重复元素
    void add(E e);

    void remove(E e);

    boolean contains(E e);

    boolean isEmpty();

    int size();
}