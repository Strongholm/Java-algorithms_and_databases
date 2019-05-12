/**
 * Домашняя работа к уроку 3 Java "algorithms and databases"
 *
 * @author Андрей Семенюк
 * @version 07.05.2019
 */

// 1. Реализовать рассмотренные структуры данных в консольных программах.
// 2. Создать программу, которая переворачивает вводимые строки (читает справа налево).
// 3. Создать класс для реализации дека.

public class Main {
    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue(4);
        queue.insert(4);
        queue.insert(5);
        queue.insert(7);
        queue.printState();
        queue.insert(6);
        while (!queue.isEmpty()) {
            System.out.print(queue.remove() + " ");
        }
    }
}