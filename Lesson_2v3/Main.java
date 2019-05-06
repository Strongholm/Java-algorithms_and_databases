/**
 * Домашняя работа к уроку 4 Java algorithms and databases
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

public class Main {
    public static void main(String[] args) {
        int n = 10;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i * 2;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + ", ");
        }

        for (int i = 0; i < n; i++) {
            if (i % 2 == 1) {
                arr[i]++;
            }
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + ", ");
        }

        MyArrayList<Character> list = new MyArrayList<>();
        list.add('z');
        list.add('d');
        list.add('x');
        list.add('r');
        list.add('f');
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.indexOf('c'));
        System.out.println(list.contains('x'));
        System.out.println(list.remove('b'));
        System.out.println(list.remove('x'));
        System.out.println(list);
        list.add('g');
        list.add('t');
        System.out.println(list);
        list.selectionSort(new CharacterComparator());
        list.insertionSort(Character::compareTo);
        System.out.println(list);
    }


}