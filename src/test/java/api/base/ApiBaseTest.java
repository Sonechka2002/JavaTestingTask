package api.base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.*;

public class ApiBaseTest {

    protected static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    protected static RequestSpecification requestSpec;
    protected static ResponseSpecification responseSpec200;
    protected static ResponseSpecification responseSpec201;

    @BeforeAll
    public static void setUp() {
        // Настройка базового URI
        baseURI = BASE_URL;

        // Request спецификация: логируем запрос
        requestSpec = new RequestSpecBuilder()
                .setContentType("application/json")
                .log(LogDetail.ALL)
                .build();

        // Response спецификация для статуса 200
        responseSpec200 = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .log(LogDetail.ALL)
                .build();

        // Response спецификация для статуса 201 (Created)
        responseSpec201 = new ResponseSpecBuilder()
                .expectStatusCode(201)
                .log(LogDetail.ALL)
                .build();
    }
}