/**
 * Домашняя работа к уроку 6 Java "algorithms and databases"
 *
 * @author Андрей Семенюк
 * @version 20.05.2019
 */

// 1. Создать и запустить программу для построения двоичного дерева.
//    В цикле построить двадцать деревьев с глубиной в 6 уровней. Данные, которыми необходимо заполнить узлы деревьев,
//    представляются в виде чисел типа int. Число, которое попадает в узел, должно генерироваться случайным образом в
//    диапазоне от -100 до 100.
// 2. Проанализировать, какой процент созданных деревьев являются несбалансированными.

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random random = new Random();
        Tree<Integer, Integer> []tree = new Tree[20];

        for (int i = 0; i < tree.length; i++) {
            tree[i] = new Tree<>();
            while (tree[i].height()<6){
                tree[i].put(random.nextInt(200)-100, 1);
            }
        }

        int countBalancedTree = 0;
        for (int i = 0; i < tree.length; i++) {
            if(tree[i].isBalanced()) {++countBalancedTree;};
        }

        System.out.println("Из " + tree.length + " деревьев  " + ((float)countBalancedTree/tree.length)*100 + "% сбалансированных или " + countBalancedTree + "шт.");
    }
}