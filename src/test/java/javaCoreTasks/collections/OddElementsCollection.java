package javaCoreTasks.collections;

import java.util.*;
import java.util.stream.Collectors;

public class OddElementsCollection {

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("Исходный массив: " + Arrays.toString(array));


        List<Integer> oddStream = getOddNumbersStream(array);
        System.out.println("Нечётные элементы (Stream API): " + oddStream);


        List<Integer> oddLoop = getOddNumbersLoop(array);
        System.out.println("Нечётные элементы (цикл): " + oddLoop);
    }


    public static List<Integer> getOddNumbersStream(Integer[] array) {
        return Arrays.stream(array)
                .filter(n -> n % 2 != 0)
                .collect(Collectors.toList());
    }


    public static List<Integer> getOddNumbersLoop(Integer[] array) {
        List<Integer> result = new ArrayList<>();
        for (int num : array) {
            if (num % 2 != 0) {
                result.add(num);
            }
        }
        return result;
    }
}
