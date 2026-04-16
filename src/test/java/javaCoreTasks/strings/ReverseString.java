package javaCoreTasks.strings;

public class ReverseString {

    public static void main(String[] args) {
        String original = "Привет Леша";

        System.out.println("Исходная строка: " + original);


        String reverse1 = reverseWithStringBuilder(original);
        System.out.println("StringBuilder: " + reverse1);


        String reverse2 = reverseWithWhile(original);
        System.out.println("Цикл while: " + reverse2);


        String reverse3 = reverseWithFor(original);
        System.out.println("Цикл for: " + reverse3);
    }


    public static String reverseWithStringBuilder(String str) {
        return new StringBuilder(str).reverse().toString();
    }


    public static String reverseWithWhile(String str) {
        char[] chars = str.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }


    public static String reverseWithFor(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = temp;
        }
        return new String(chars);
    }
}