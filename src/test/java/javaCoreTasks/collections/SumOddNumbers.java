package javaCoreTasks.collections;

import java.util.Arrays;
import java.util.List;

public class SumOddNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 11);

        System.out.println("Исходные числа: " + numbers);


        int sumStream = numbers.stream()
                .filter(n -> n % 2 != 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Сумма нечётных (Stream API): " + sumStream);


        int sumLoop = 0;
        for (int num : numbers) {
            if (num % 2 != 0) {
                sumLoop += num;
            }
        }
        System.out.println("Сумма нечётных (цикл): " + sumLoop);
    }
}
