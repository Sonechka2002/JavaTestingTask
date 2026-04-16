package javaCoreTasks.collections;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveDuplicates {

    public static void main(String[] args) {

        List<String> listWithDuplicates = new ArrayList<>(Arrays.asList(
                "яблоко", "банан", "яблоко", "апельсин", "банан", "груша", "яблоко"
        ));

        System.out.println("Исходный список: " + listWithDuplicates);


        List<String> withoutDuplicatesStream = removeDuplicatesStream(listWithDuplicates);
        System.out.println("Stream API: " + withoutDuplicatesStream);


        List<String> withoutDuplicatesCollections = removeDuplicatesCollections(listWithDuplicates);
        System.out.println("Коллекции: " + withoutDuplicatesCollections);
    }


    public static List<String> removeDuplicatesStream(List<String> list) {
        return list.stream()
                .distinct()
                .collect(Collectors.toList());
    }


    public static List<String> removeDuplicatesCollections(List<String> list) {
        Set<String> set = new LinkedHashSet<>(list);
        return new ArrayList<>(set);
    }
}
