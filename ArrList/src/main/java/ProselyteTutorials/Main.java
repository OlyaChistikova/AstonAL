package ProselyteTutorials;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // Создаем экземпляр нашего списка для целых чисел
        MyArrayListImpl<Integer> myList = new MyArrayListImpl<>();

        // Добавляем элементы в список
        myList.add(10);
        myList.add(20);
        myList.add(30);

        // Добавляем элемент в конкретную позицию
        myList.add(1, 15);

        // Выводим размер списка
        System.out.println("Размер списка: " + myList.size());

        // Выводим все элементы списка
        System.out.println("Элементы списка:");
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }

        // Удаляем элемент по индексу
        myList.remove(1);
        System.out.println("Список после удаления элемента по индексу 1:");
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }

        // Очищаем список
        myList.clear();
        System.out.println("Размер списка после очистки: " + myList.size());

        // Добавляем новые элементы
        myList.add(25);
        myList.add(5);
        myList.add(15);
        myList.add(30);
        myList.add(10);

        // Квакий сортировка
        Comparator<Integer> comparator = (a, b) -> a - b;
        myList.quicksort(0, myList.size() - 1, comparator);

        // Выводим отсортированный список
        System.out.println("Отсортированный список:");
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }
    }
}
