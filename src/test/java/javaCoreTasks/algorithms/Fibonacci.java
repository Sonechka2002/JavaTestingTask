package javaCoreTasks.algorithms;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

    public static void main(String[] args) {
        int count = 7;

        List<Integer> fibonacciNumbers = new ArrayList<>();
        int sum = 0;

        int a = 0;
        int b = 1;

        for (int i = 0; i < count; i++) {
            fibonacciNumbers.add(a);
            sum += a;


            int next = a + b;
            a = b;
            b = next;
        }

        System.out.println("Первые 7 чисел Фибоначчи: " + fibonacciNumbers);
        System.out.println("Сумма этих чисел: " + sum);
    }
}
