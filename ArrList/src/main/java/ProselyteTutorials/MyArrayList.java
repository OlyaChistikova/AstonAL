package ProselyteTutorials;

import java.util.Comparator;

public interface MyArrayList<T> {
    void add(T element);
    void add(int index, T element);
    T get(int index);
    void remove(int index);
    void clear();
    void sort(Comparator<T> comparator);
}
