package exercise;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import io.javalin.Javalin;
import io.ebean.DB;

import exercise.domain.User;
import exercise.domain.query.QUser;
import io.ebean.Database;

class AppTest {

    private static Javalin app;
    private static String baseUrl;

    // BEGIN
    @BeforeAll
    public static void beforeAll() {
        app = App.getApp();
        app.start(0);
        int port = app.port();
        baseUrl = "http://localhost:" + port;
    }

    @AfterAll
    public static void afterAll() {
        // Останавливаем приложение
        app.stop();
    }
    // END

    // Между тестами база данных очищается
    // Благодаря этому тесты не влияют друг на друга
    @BeforeEach
    void beforeEach() {
        Database db = DB.getDefault();
        db.truncate("users");
        User existingUser = new User("Wendell", "Legros", "a@a.com", "123456");
        existingUser.save();
    }

    @Test
    void testUsers() {

        // Выполняем GET запрос на адрес http://localhost:port/users
        HttpResponse<String> response = Unirest
            .get(baseUrl + "/users")
            .asString();
        // Получаем тело ответа
        String content = response.getBody();

        // Проверяем код ответа
        assertThat(response.getStatus()).isEqualTo(200);
        // Проверяем, что страница содержит определенный текст
        assertThat(response.getBody()).contains("Wendell Legros");
    }

    @Test
    void testNewUser() {

        HttpResponse<String> response = Unirest
            .get(baseUrl + "/users/new")
            .asString();

        assertThat(response.getStatus()).isEqualTo(200);
    }

    // BEGIN
    @Test
    void testNewUserCreation1() {

        HttpResponse<String> responsePost = Unirest
                .post(baseUrl + "/users")
                .field("firstName", "Bob")
                .field("lastName", "Bobov")
                .field("email", "bobic@bobov.com")
                .field("password", "12345678")
                .asString();
        assertThat(responsePost.getStatus()).isEqualTo(302);
        User testUser = new QUser()
                .firstName.equalTo("Bob")
                .lastName.equalTo("Bobov")
                .email.equalTo("bobic@bobov.com")
                .findOne();
        assertThat(testUser).isNotNull();
        assertThat(testUser.getFirstName()).isEqualTo("Bob");
        assertThat(testUser.getLastName()).isEqualTo("Bobov");
        String[] email = testUser.getEmail().split("@");
        assertThat(email).isNotEmpty();
        assertThat(email[0].length()).isGreaterThan(0);
        assertThat(email[1].length()).isGreaterThan(3);
        assertThat(email[1]).contains(".");
        var userPasswordLenght = testUser.getPassword().length();
        assertThat(userPasswordLenght).isGreaterThan(4);
    }
    @Test
    void testNewUserCreationNegative() {

        HttpResponse<String> responsePost = Unirest
                .post(baseUrl + "/users")
                .field("firstName", "")
                .field("lastName", "Bobov")
                .field("email", "bobic@bobov.com")
                .field("password", "12345678")
                .asString();
        assertThat(responsePost.getStatus()).isEqualTo(422);
        User testUser = new QUser()
                .firstName.equalTo("")
                .lastName.equalTo("Bobov")
                .email.equalTo("bobic@bobov.com")
                .findOne();
        assertThat(testUser).isNull();


        assertThat(responsePost.getBody()).contains("Имя не должно быть пустым");

    }
    // END
}
