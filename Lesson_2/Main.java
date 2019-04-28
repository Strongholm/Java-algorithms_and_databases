/**
 * Домашняя работа к уроку 2 "Алгоритмы и структуры данных на Java"
 *
 * @author Андрей Семенюк
 * @version 28.04.2019
 */

/*
 * - Создать массив большого размера (миллион элементов).
 * - Написать методы удаления, добавления, поиска элемента массива.
 * - Заполнить массив случайными числами.
 * - Написать методы, сортировок и вывести на экран скорость выполнения каждой, используя метод System.nanoTime().
 */
public class Main {

    public static void main(String[] args) {
        int testArraySize = 1000000;

        DynamicArray<Integer> test = new DynamicArray<>();

        test.randomFill(1000000, 1, 10000);

        Sorting.startTimer();
        Sorting.sortBubble(test.toArray());
        System.out.printf("Bubble sort array N = %d time (nanosec.): %d",
                testArraySize, Sorting.getResultTimeDiff());

        test = new DynamicArray<>();
        test.randomFill(1000000, 1, 10000);

        Sorting.startTimer();
        Sorting.sortSelect(test.toArray());
        System.out.printf("Select sort array N = %d time (nanosec.): %d",
                testArraySize, Sorting.getResultTimeDiff());

        test = new DynamicArray<>();
        test.randomFill(1000000, 1, 10000);

        Sorting.startTimer();
        Sorting.sortInsert(test.toArray());
        System.out.printf("Insert sort array N = %d time (nanosec.): %d",
                testArraySize, Sorting.getResultTimeDiff());
    }

}