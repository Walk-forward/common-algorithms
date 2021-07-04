package com.github.algorithms.structure.set;

import com.github.algorithms.structure.array.ArrayList;
import com.github.algorithms.structure.linked.LinkedList;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 散列集
 * @param <E>
 */
public class HashSet<E> implements Iterator<E>, Iterable<E> {

    /**
     * 桶
     */
    private ArrayList<LinkedList<E>> barrel;

    /**
     * 桶大小
     */
    private int barrelSize;

    /**
     * 桶大小
     */
    private int size;

    /**
     * 装载因子
     */
    private final double loadFactor;

    /**
     * 迭代器当前节点
     */
    private LinkedList<E> iteratorLinkedList;

    public HashSet() {
        this(16);
    }

    /**
     * 创建指定桶大小的散列表
     * @param barrelSize 桶大小
     */
    public HashSet(int barrelSize) {
        this(barrelSize, 0.75);
    }

    /**
     * 创建指定桶大小和装载因子的散列表
     * @param barrelSize 桶大小
     * @param loadFactor 装载因子
     */
    public HashSet(int barrelSize, double loadFactor) {
        if (barrelSize < 16) {
            barrelSize = 16;
        }else {
            final int MAXIMUM_CAPACITY = 1 << 30;
            int n = -1 >>> Integer.numberOfLeadingZeros(barrelSize - 1);
            barrelSize = (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
        }

        this.barrelSize = barrelSize;
        this.loadFactor = loadFactor;
        this.barrel = new ArrayList<>(this.barrelSize);
    }

    /**
     * 散列函数
     * @param element 键
     * @return 键取余桶大小
     */
    private int hashFunction(E element) {
        return element.hashCode() % barrelSize;
    }

    /**
     * 元素数量
     * @return 元素数量
     */
    private int size() {
        return this.size;
    }

    /**
     * 将节点放入散列表
     * @param element 键
     */
    public void add(E element) {
        int hashCode = hashFunction(element);
        LinkedList<E> linkedList = barrel.get(hashCode);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
        }
        boolean f = true;
        Iterator<E> iterator = linkedList.iterator();
        for (int i = 0; iterator.hasNext(); i++) {
            E e = iterator.next();
            if (e.equals(element)) {
                linkedList.set(i, element);
                f = false;
                break;
            }
        }
        if (f) {
            if ((double)size / barrelSize > loadFactor) {
                barrelSize = barrelSize * 2;
                rehashed();
            }
            linkedList.insert(element);
            barrel.set(hashCode, linkedList);
            this.size ++;
        }
    }

    /**
     * 再散列
     */
    private void rehashed() {
        ArrayList<LinkedList<E>> newArrayList = new ArrayList<>(barrelSize);
        barrel.forEach(newArrayList::add);
        barrel = newArrayList;
    }

    private boolean barrelHasNext() {
        while (barrel.hasNext()) {
            iteratorLinkedList = barrel.next();
            if (iteratorLinkedList != null) {
                iteratorLinkedList.iterator();
                return true;
            }
        }
        return false;
    }

    private boolean iteratorLinkedListHasNext() {
        if (iteratorLinkedList == null) {
            return barrelHasNext();
        }else if (iteratorLinkedList.hasNext()) {
            return true;
        }
        return barrelHasNext();
    }
    @Override
    public Iterator<E> iterator() {
        barrel.iterator();
        return this;
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public boolean hasNext() {
        return iteratorLinkedListHasNext();
    }

    @Override
    public E next() {
        return iteratorLinkedList.next();
    }

}
