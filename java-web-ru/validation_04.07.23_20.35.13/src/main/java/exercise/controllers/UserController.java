package exercise.controllers;

import io.javalin.http.Handler;
import java.util.List;
import java.util.Map;
import io.javalin.validation.Validator;
import io.javalin.validation.ValidationError;
import io.javalin.validation.JavalinValidation;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.lang3.StringUtils;
import io.javalin.http.Context;

import exercise.domain.User;
import exercise.domain.query.QUser;

public final class UserController {

    private static void removeFlashMessage(Context ctx) {
        ctx.sessionAttribute("flash", null);
    }

    public static Handler listUsers = ctx -> {

        List<User> users = new QUser()
            .orderBy()
                .id.asc()
            .findList();

        ctx.attribute("users", users);
        ctx.render("users/index.html");
        removeFlashMessage(ctx);
    };

    public static Handler showUser = ctx -> {
        long id = ctx.pathParamAsClass("id", Long.class).getOrDefault(null);

        User user = new QUser()
            .id.equalTo(id)
            .findOne();

        ctx.attribute("user", user);
        ctx.render("users/show.html");
    };

    public static Handler newUser = ctx -> {

        ctx.attribute("errors", Map.of());
        ctx.attribute("user", Map.of());
        ctx.render("users/new.html");
    };

    public static Handler createUser = ctx -> {
        // BEGIN
        String newUserFirstName = ctx.formParam("firstName");
        String newUserLastName = ctx.formParam("lastName");
        String newUserEmail = ctx.formParam("email");
        String newUserPassword = ctx.formParam("password");

        Validator<String> firstNameValidator = ctx.formParamAsClass(newUserFirstName, String.class)
                .check(x -> !x.isEmpty(), "Name shouldn't be empty");

        Validator<String> lastNameValidator = ctx.formParamAsClass(newUserLastName, String.class)
                .check(x -> !x.isEmpty(), "Last name shouldn't be empty");

        Validator<String> emailValidator = ctx.formParamAsClass(newUserEmail, String.class)
                .check(x-> EmailValidator.getInstance().isValid(x),"Email shouldn't be empty");

        Validator<String> passvordValidator = ctx.formParamAsClass(newUserPassword, String.class)
                .check(x -> x.length() > 4, "Password length should be more than 4 symbols")
                .check(x -> StringUtils.isNumeric(x), "Password should consist with only digits");

        Map<String, List<ValidationError<? extends Object>>> errors = JavalinValidation.collectErrors(
                firstNameValidator,
                lastNameValidator,
                emailValidator,
                passvordValidator
                );

        if (!errors.isEmpty()) {
            // Устанавливаем код ответа
            ctx.status(422);
            // Передаем ошибки и данные компании
            ctx.attribute("errors", errors);
            User notCorrectUser = new User(newUserFirstName, newUserLastName, newUserEmail, newUserPassword);
            ctx.attribute("user", notCorrectUser);
            ctx.render("users/new.html");
            return;
        }
        User newUser = new User(newUserFirstName, newUserLastName, newUserEmail, newUserPassword);
        newUser.save();
        ctx.sessionAttribute("flash", "User successfully created");
        ctx.redirect("/users");
        // END
    };
}
