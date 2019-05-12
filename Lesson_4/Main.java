/**
 * Домашняя работа к уроку 4 Java "algorithms and databases"
 *
 * @author Андрей Семенюк
 * @version 13.05.2019
 */

// 1. Реализовать все классы, рассмотренные в данном уроке.
// 2. В методе main LinkIteratorApp проверить все методы итератора.

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Character> list = new MyLinkedList<>();
        list.addFirst('c');
        list.addFirst('b');
        if(list.contains('b')){
            list.addFirst('a');
        }
        System.out.println(list);
        list.addLast('d');
        list.removeFirst();
        list.remove('c');
        list.add(2, 'e');
        System.out.println(list);
        list.set(1, 'c');
        System.out.println(list.get(1));
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.addLast('o');
        list.addFirst('k');
        list.addLast('p');
        System.out.println(list);
    }
}