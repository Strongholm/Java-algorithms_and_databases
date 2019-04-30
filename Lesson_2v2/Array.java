/**
 * Домашняя работа к уроку 2 "Алгоритмы и структуры данных на Java"
 *
 * @author Андрей Семенюк
 * @version 30.04.2019
 */

/*
 * 1. Повторить реализацию АТД «список» с помощью структуры данных «массив» (не подглядывать, пытаться самим сделать).
 * 2. Провести эксперимент по сравнению эффективности алгоритмов сортировки:
 *    заполнить список случайными N целыми числами в диапазоне от a до b;
 *    запустить алгоритмы сортировки, засекая время их выполнения;
 *    повторить эксперимент M раз;
 *    свести данные в таблицу.
 */

import java.util.Comparator;
import java.util.Iterator;

public class Array<T> implements Iterable<T> {

    private Object[] list = new Object[1];
    private int size = 0;

    public int getSize() {
        return size;
    }

    public void add(T item) {
        if (size == list.length) {
            resize(2 * list.length);
        }

        list[size] = item;
        size++;
    }

    public int indexOfElement(T item) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    private void resize(int cap) {
        Object[] newList = new Object[cap];
        for (int i = 0; i < size; i++) {
            newList[i] = list[i];
        }
        list = newList;
    }

    public boolean contains(T item) {
        return indexOfElement(item) != -1;
    }

    public boolean remove(T item) {
        int i = 0;

        while (i < size && !list[i].equals(item)) {
            i++;
        }

        if (i == size) {
            return false;
        }

        for (int j = i; j < size - 1; j++) {
            list[j] = list[j + 1];
        }
        list[size - 1] = null;
        size--;

        if (size == list.length / 4 && size > 0) {
            resize(list.length / 2);
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < size; i++) {
            builder.append(list[i]);
            builder.append(", ");
        }
        return builder.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new MyListIterator();
    }


    private class MyListIterator implements Iterator<T> {

        int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new IndexOutOfBoundsException();
            }
            T item = (T) list[cursor];
            cursor++;
            return item;
        }

    }

    private void exchange(int i, int j) {
        Object newObject = list[i];
        list[i] = list[j];
        list[j] = newObject;
    }


    private boolean less(T item1, T item2, Comparator<T> cmp) {
        return cmp.compare(item1, item2) < 0;
    }

    public void Selection(Comparator<T> cmp) {
        for (int i = 0; i < size; i++) {
            int min = i;
            for (int j = i; j > 0; j--) {
                if (less((T) list[j], (T) list[j - 1], cmp)) {
                    min = j;
                }
            }
            exchange(i, min);

        }
    }

    public void insertion(Comparator<T> cmp) {
        for (int i = 0; i < size; i++) {
            for (int j = i; j > 0; j--) {
                if (less((T) list[j], (T) list[j - 1], cmp)) {
                    exchange(j, j - 1);
                } else {
                    break;
                }
            }

        }
    }

    public boolean binary(T item, Comparator<T> cmp) {
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (cmp.compare(item, (T) list[mid]) < 0) {
                high = mid - 1;
            }
            if (cmp.compare(item, (T) list[mid]) > 0) {
                low = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    private class MyComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

}