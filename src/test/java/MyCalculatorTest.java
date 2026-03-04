import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MyCalculatorTest {

    // 1. Обычный тест (проверяем метод sum)
    @Test
    void testSum() {
        System.out.println("Тест запущен в потоке: " + Thread.currentThread().getName());
        int result = MyCalculator.sum(5, 5);
        Assertions.assertEquals(10, result, "Сумма 5 + 5 должна быть 10");
    }

    // 2. Параметризованный тест (проверяем метод isGreaterThanTen с разными данными)
    @ParameterizedTest

    @ValueSource(ints = {11, 15, 100}) // Эти числа ДОЛЖНЫ быть больше 10
    void testIsGreaterThanTen(int number) {
        System.out.println("Тест запущен в потоке: " + Thread.currentThread().getName());
        Assertions.assertTrue(MyCalculator.isGreaterThanTen(number),
                "Число " + number + " должно быть больше 10");
    }
}