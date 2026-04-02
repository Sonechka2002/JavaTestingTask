package api.base;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class JsonPlaceholderApiTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void testGetUserById() {
        // 1. Отправляем запрос и получаем ответ
        Response response = given()
                .when()
                .get("/users/1")
                .then()
                .statusCode(200)
                .extract()
                .response();

        // 2. Десериализуем JSON в объект User
        User actualUser = response.as(User.class);

        // 3. Создаём эталонный объект
        User expectedUser = new User();
        expectedUser.setId(1);
        expectedUser.setName("Leanne Graham");
        expectedUser.setUsername("Bret");
        expectedUser.setEmail("Sincere@april.biz");

        // 4. Выводим результат
        System.out.println("Полученный пользователь: ID=" + actualUser.getId() +
                ", Name=" + actualUser.getName() +
                ", Username=" + actualUser.getUsername() +
                ", Email=" + actualUser.getEmail());

        System.out.println("Ожидаемый пользователь: ID=1, Name=Leanne Graham, Username=Bret, Email=Sincere@april.biz");

        // 5. Сравниваем
        Assertions.assertEquals(expectedUser.getId(), actualUser.getId(), "ID не совпадает");
        Assertions.assertEquals(expectedUser.getName(), actualUser.getName(), "Имя не совпадает");
        Assertions.assertEquals(expectedUser.getUsername(), actualUser.getUsername(), "Username не совпадает");
        Assertions.assertEquals(expectedUser.getEmail(), actualUser.getEmail(), "Email не совпадает");

        System.out.println("✅ Тест пройден! Объекты совпадают.");
    }
}