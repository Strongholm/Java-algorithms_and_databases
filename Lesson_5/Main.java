/**
 * Домашняя работа к уроку 5 Java "algorithms and databases"
 *
 * @author Андрей Семенюк
 * @version 16.05.2019
 */

import java.util.Deque;
import java.util.NoSuchElementException;

public class Main {

// 1. Написать программу по возведению целого числа в натуральную степень циклическим и рекурсивным алгоритмом.

    public long exponentiationCycle(int a, int b) {
        if (b < 0) throw new ArithmeticException("The degree cannot be a negative number.");
        long result = a;
        for (int i = 2; i < b + 1; i++) {
            result *= a;
        }
        return result;
    }

    public long exponentiationRecursio(int a, int b) {
        if (b < 0) throw new ArithmeticException("The degree cannot be a negative number.");
        if (b == 1) return a;
        return exponentiationRecursio(a, b - 1) * a;
    }

// 2. Познакомиться с головоломкой Ханойские башни.
//    Реализовать рекурсивный и циклический алгоритмы решения этой головоломки.

    public void towerHanoi(int count, Deque<Integer> stemA, Deque<Integer> stemB, Deque<Integer> stemC) {

        if (count < 0) throw new ArithmeticException("The degree cannot be a negative number.");

        for (int i = count; i > 0; i--) {
            stemA.push(i);
        }
//
//        while (stemC.size() != count) {
//            try {
//                if (count % 2 == 0) {
//                    if (stemA.peek() < stemB.peek()) {
//                        stemB.push(stemA.pop());
//                    } else {
//                        stemA.push(stemB.pop());
//                    }
//                }
//                if (count % 2 == 1) {
//                    if (stemA.peek() < stemC.peek()) {
//                        stemC.push(stemA.pop());
//                    } else {
//                        stemA.push(stemC.pop());
//                    }
//                }
//            } catch (NullPointerException exp) {
//                try {
//                    if (count % 2 == 0 && stemB.isEmpty()) {
//                        stemB.push(stemA.pop());
//                    } else if (count % 2 == 1 && stemC.isEmpty()) {
//                        stemC.push(stemA.pop());
//                    } else if (count % 2 == 0 && stemA.isEmpty()) {
//                        stemA.push(stemB.pop());
//                    } else if (count % 2 == 1 && stemA.isEmpty()) {
//                        stemA.push(stemC.pop());
//                    }
//                } catch (NoSuchElementException e) {
//                    break;
//                }
//            }
//
//            try {
//                if (count % 2 == 0) {
//                    if (stemA.peek() < stemC.peek()) {
//                        stemC.push(stemA.pop());
//                    } else {
//                        stemA.push(stemC.pop());
//                    }
//                }
//                if (count % 2 == 1) {
//                    if (stemA.peek() < stemB.peek()) {
//                        stemB.push(stemA.pop());
//                    } else {
//                        stemA.push(stemB.pop());
//                    }
//                }
//            } catch (NullPointerException exp) {
//                try {
//                    if (count % 2 == 1 && stemB.isEmpty()) {
//                        stemB.push(stemA.pop());
//                    } else if (count % 2 == 0 && stemC.isEmpty()) {
//                        stemC.push(stemA.pop());
//                    } else if (count % 2 == 1 && stemA.isEmpty()) {
//                        stemA.push(stemB.pop());
//                    } else if (count % 2 == 0 && stemA.isEmpty()) {
//                        stemA.push(stemC.pop());
//                    }
//                } catch (NoSuchElementException e) {
//                    break;
//                }
//            }
//
//            try {
//                if (stemB.peek() < stemC.peek()) {
//                    stemC.push(stemB.pop());
//                } else {
//                    stemB.push(stemC.pop());
//                }
//            } catch (NullPointerException exp) {
//                if (stemC.isEmpty()) {
//                    stemC.push(stemB.pop());
//                } else if (stemB.isEmpty()) {
//                    stemB.push(stemC.pop());
//                }
//            }
//        }
    }
}