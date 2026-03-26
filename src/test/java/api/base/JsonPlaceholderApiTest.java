package api;

import api.base.ApiBaseTest;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class JsonPlaceholderApiTest extends ApiBaseTest {

    // 1. GET запрос - получение всех постов
    @Test
    public void testGetAllPosts() {
        given()
                .spec(requestSpec)
                .when()
                .get("/posts")
                .then()
                .spec(responseSpec200)
                .body("size()", greaterThan(0))
                .body("[0].id", notNullValue())
                .body("[0].title", notNullValue());
    }

    // 2. GET запрос - получение одного поста по ID
    @Test
    public void testGetPostById() {
        int postId = 1;

        given()
                .spec(requestSpec)
                .when()
                .get("/posts/" + postId)
                .then()
                .spec(responseSpec200)
                .body("id", equalTo(postId))
                .body("userId", notNullValue())
                .body("title", notNullValue())
                .body("body", notNullValue());
    }

    // 3. POST запрос - создание нового поста
    @Test
    public void testCreateNewPost() {
        Map<String, Object> newPost = new HashMap<>();
        newPost.put("userId", 1);
        newPost.put("title", "Мой новый пост");
        newPost.put("body", "Текст моего нового поста");

        given()
                .spec(requestSpec)
                .body(newPost)
                .when()
                .post("/posts")
                .then()
                .spec(responseSpec201)  // используем спецификацию для 201
                .body("userId", equalTo(1))
                .body("title", equalTo("Мой новый пост"))
                .body("body", equalTo("Текст моего нового поста"))
                .body("id", notNullValue());
    }

    // 4. PUT запрос - полное обновление поста
    @Test
    public void testUpdatePost() {
        int postId = 1;

        Map<String, Object> updatedPost = new HashMap<>();
        updatedPost.put("userId", 1);
        updatedPost.put("id", postId);
        updatedPost.put("title", "Обновленный заголовок");
        updatedPost.put("body", "Обновленный текст поста");

        given()
                .spec(requestSpec)
                .body(updatedPost)
                .when()
                .put("/posts/" + postId)
                .then()
                .spec(responseSpec200)
                .body("id", equalTo(postId))
                .body("title", equalTo("Обновленный заголовок"))
                .body("body", equalTo("Обновленный текст поста"));
    }

    // 5. DELETE запрос - удаление поста
    @Test
    public void testDeletePost() {
        int postId = 1;

        given()
                .spec(requestSpec)
                .when()
                .delete("/posts/" + postId)
                .then()
                .spec(responseSpec200);  // используем спецификацию для 200
    }
}