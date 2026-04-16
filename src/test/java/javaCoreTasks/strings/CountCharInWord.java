package javaCoreTasks.strings;

public class CountCharInWord {

    public static void main(String[] args) {
        String word = "Аббревиатура";
        char letter = 'а';

        System.out.println("Слово: " + word);
        System.out.println("Символ: " + letter);


        int countSensitive = countCharSensitive(word, letter);
        System.out.println("Кол-во (с учётом регистра): " + countSensitive);


        int countInsensitive = countCharInsensitive(word, letter);
        System.out.println("Кол-во (без учёта регистра): " + countInsensitive);
    }


    public static int countCharSensitive(String word, char letter) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                count++;
            }
        }
        return count;
    }


    public static int countCharInsensitive(String word, char letter) {
        int count = 0;
        String lowerWord = word.toLowerCase();
        char lowerLetter = Character.toLowerCase(letter);

        for (int i = 0; i < lowerWord.length(); i++) {
            if (lowerWord.charAt(i) == lowerLetter) {
                count++;
            }
        }
        return count;
    }
}
