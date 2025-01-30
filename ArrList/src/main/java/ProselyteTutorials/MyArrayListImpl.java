package ProselyteTutorials;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Реализация динамического массива (списка) на основе массива объектов.
 *
 * @param <T> тип элементов списка.
 */
public class MyArrayListImpl<T> implements MyArrayList<T>{
    private Object[] elements; // Массив для хранения элементов.
    private int size; // Текущее количество элементов.
    private static final int DEFAULT_CAPACITY = 10; // Начальная емкость массива.

    /**
     * Создает новый экземпляр MyArrayListImpl с начальной емкостью.
     */
    public MyArrayListImpl() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Добавляет элемент в конец списка.
     *
     * @param element элемент для добавления.
     */
    public void add(T element) {
        ensureCapacity();
        elements[size++] = element;
    }

    /**
     * Добавляет элемент по указанному индексу.
     *
     * @param index индекс, по которому необходимо добавить элемент.
     * @param element элемент для добавления.
     * @throws IndexOutOfBoundsException если индекс вне диапазона.
     */
    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона");
        }
        if (size == elements.length) {
            resize(); // Увеличиваем размер массива, если необходимо
        }
        System.arraycopy(elements, index, elements, index + 1, size - index); // Сдвигаем элементы
        elements[index] = element; // Вставляем новый элемент
        size++;
    }

    /**
     * Возвращает элемент по указанному индексу.
     *
     * @param index индекс элемента.
     * @return элемент по указанному индексу.
     * @throws IndexOutOfBoundsException если индекс вне диапазона.
     */
    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    /**
     * Удаляет элемент по указанному индексу.
     *
     * @param index индекс элемента, который необходимо удалить.
     * @throws IndexOutOfBoundsException если индекс вне диапазона.
     */
    @Override
    public void remove(int index) {
        checkIndex(index);
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null; // Удаляем ссылку для сборщика мусора
    }

    /**
     * Возвращает текущее количество элементов в списке.
     *
     * @return размер списка.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Увеличивает размер массива, если он заполнен.
     */
    private void ensureCapacity() {
        if (size == elements.length) {
            int newCapacity = elements.length * 2;
            Object[] newArray = new Object[newCapacity];
            System.arraycopy(elements, 0, newArray, 0, elements.length);
            elements = newArray;
        }
    }

    /**
     * Проверяет индекс для исключений.
     *
     * @param index индекс для проверки.
     * @throws IndexOutOfBoundsException если индекс вне диапазона.
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
    /**
     * Увеличиваем размер массива в два раза
     *
     */
    private void resize() {
        elements = Arrays.copyOf(elements, elements.length * 2); // Увеличиваем размер массива
    }

    /**
     * Очищает список, удаляя все элементы.
     */
    @Override
    public void clear() {
        // Очищаем коллекцию
        size = 0;
        Arrays.fill(elements, null); // Удаляем ссылки на объекты
    }
    /**
     * Сортирует элементы списка с использованием указанного компаратора.
     *
     * @param comparator компаратор для определения порядка сортировки.
     */
    @Override
    public void sort(Comparator<T> comparator) {
        // Сортируем коллекцию
        Arrays.sort((T[]) elements, 0, size, comparator);
    }

    /**
    * Реализует алгоритм быстрой сортировки на массиве.
    *
    * @param low начальный индекс сортируемого подмассива.
    * @param high конечный индекс сортируемого подмассива.
    * @param comparator компаратор для сравнения элементов.
    */
    @Override
    public void quicksort(int low, int high, Comparator<T> comparator) {
        if (low < high) {
            int pi = partition(low, high, comparator);
            quicksort(low, pi - 1, comparator);
            quicksort(pi + 1, high, comparator);
        }
    }
    /**
     * Разделяет массив и возвращает индекс разделителя.
     *
     * @param low начальный индекс.
     * @param high конечный индекс.
     * @param comparator компаратор для сравнения элементов.
     * @return индекс разделителя.
     */
    private int partition(int low, int high, Comparator<T> comparator) {
        T pivot = (T) elements[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (comparator.compare((T) elements[j], pivot) <= 0) {
                i++;
                Object temp = elements[i];
                elements[i] = elements[j];
                elements[j] = temp;
            }
        }
        Object temp = elements[i + 1];
        elements[i + 1] = elements[high];
        elements[high] = temp;
        return i + 1;
    }

}