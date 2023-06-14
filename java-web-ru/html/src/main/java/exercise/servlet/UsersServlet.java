package exercise.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;

import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang3.ArrayUtils;

public class UsersServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        String pathInfo = request.getPathInfo();

        if (pathInfo == null) {
            showUsers(request, response);
            return;
        }

        String[] pathParts = pathInfo.split("/");
        String id = ArrayUtils.get(pathParts, 1, "");

        showUser(request, response, id);
    }

    private List<HashMap<String, String>> getUsers() throws JsonProcessingException, IOException {
        // BEGIN
        Path path = Paths.get("src/main/resources/users.json");
        String jsonUsers = Files.readString(path);
        ObjectMapper objectMapper = new ObjectMapper();
        List<HashMap<String, String>> users = objectMapper.readValue(jsonUsers, new TypeReference<>() { });
        return users;
        // END
    }

    private void showUsers(HttpServletRequest request,
                          HttpServletResponse response)
                throws IOException {

        // BEGIN
        PrintWriter out = response.getWriter();
        out.println("""
                <!DOCTYPE html>
                <html lang=\"ru\">
                    <head>
                        <meta charset=\"UTF-8\">
                        <title>Example application</title>
                    </head>
                    <body>
                    <table>
                """);

        getUsers().forEach(x -> out.println("<tr><td>"
                + x.get("id")
                + "</td><td><a href=\"/users/"
                +  x.get("id")
                + "\">"
                + x.get("firstName")
                + " "
                + x.get("lastName")
                + "</a></td></tr>"));
        out.println("""
                </table>
                    </body>
                </html>
                """);
        // END


    }

    private void showUser(HttpServletRequest request,
                         HttpServletResponse response,
                         String id)
                 throws IOException {

        // BEGIN
        PrintWriter out = response.getWriter();
        StringBuilder s = new StringBuilder();
        s.append(getUsers()
                .stream()
                .filter(m -> m.containsValue(id))
                .findAny().orElseGet(() -> {
                    try {
                        response.sendError(404);
                    } catch (IOException e) {
                        throw  new RuntimeException(e);
                    }
                    return null;
                }));
        out.println(s);
        // END
    }
}
