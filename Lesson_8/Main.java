/**
 * Домашняя работа к уроку 8 Java "algorithms and databases"
 *
 * @author Андрей Семенюк
 * @version 26.05.2019
 */

// 1. Создать программу, реализующую метод цепочек.

public class Main {


    public static void main(String[] args) {

        MyLinearProbingHashMap<Integer, Integer> liner = new MyLinearProbingHashMap<>();
        int tmp = 1;
        liner.put(1 , tmp *= 2);
        liner.put(2 , tmp *= 2);
        liner.put(1 , tmp *= 2);
        liner.put(3 , tmp *= 2);
        liner.put(4 , tmp *= 2);


        System.out.println(liner.toString());

        System.out.println("Размер списка: " + liner.size());


        for(int i = 0; i<150; i++){
            liner.put(i , tmp += 2);
        }

        System.out.println("Размер списка: " + liner.size());
    }
}