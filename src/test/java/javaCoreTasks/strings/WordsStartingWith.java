package javaCoreTasks.strings;

import java.util.*;
import java.util.stream.Collectors;

public class WordsStartingWith {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("яблоко", "банан", "апельсин", "арбуз", "вишня", "абрикос", "груша");
        char letter = 'а';

        System.out.println("Список слов: " + words);
        System.out.println("Буква: " + letter);


        List<String> resultStream = filterWordsStartingWithStream(words, letter);
        System.out.println("Stream API: " + resultStream);


        List<String> resultLoop = filterWordsStartingWithLoop(words, letter);
        System.out.println("Цикл: " + resultLoop);
    }


    public static List<String> filterWordsStartingWithStream(List<String> words, char letter) {
        return words.stream()
                .filter(word -> word.toLowerCase().startsWith(String.valueOf(letter).toLowerCase()))
                .collect(Collectors.toList());
    }


    public static List<String> filterWordsStartingWithLoop(List<String> words, char letter) {
        List<String> result = new ArrayList<>();
        String targetLetter = String.valueOf(letter).toLowerCase();

        for (String word : words) {
            if (word.toLowerCase().startsWith(targetLetter)) {
                result.add(word);
            }
        }
        return result;
    }
}