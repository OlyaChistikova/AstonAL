package ProselyteTutorials;

import java.util.Comparator;
/**
 * Интерфейс для реализации динамического массива (списка).
 *
 * @param <T> тип элементов списка.
 */
public interface MyArrayList<T> {
    /**
     * Добавляет элемент в конец списка.
     *
     * @param element элемент для добавления.
     */
    void add(T element);
    /**
     * Добавляет элемент по указанному индексу.
     *
     * @param index индекс, по которому необходимо добавить элемент.
     * @param element элемент для добавления.
     * @throws IndexOutOfBoundsException если индекс вне диапазона.
     */
    void add(int index, T element);
    /**
     * Возвращает элемент по указанному индексу.
     *
     * @param index индекс элемента.
     * @return элемент по указанному индексу.
     * @throws IndexOutOfBoundsException если индекс вне диапазона.
     */
    T get(int index);
    /**
     * Удаляет элемент по указанному индексу.
     *
     * @param index индекс элемента, который необходимо удалить.
     * @throws IndexOutOfBoundsException если индекс вне диапазона.
     */
    void remove(int index);
    /**
     * Возвращает текущее количество элементов в списке.
     *
     * @return размер списка.
     */
    int size();
    /**
     * Очищает список, удаляя все элементы.
     */
    void clear();
    /**
     * Сортирует элементы списка с использованием указанного компаратора.
     *
     * @param comparator компаратор, который определяет порядок сортировки.
     */
    void sort(Comparator<T> comparator);
    /**
     * Метод для быстрой сортировки списка с использованием компаратора.
     *
     * @param low начальный индекс сортируемого подмассива.
     * @param high конечный индекс сортируемого подмассива.
     * @param comparator компаратор для определения порядка сортировки.
     */
     void quicksort(int low, int high, Comparator<T> comparator);
}
