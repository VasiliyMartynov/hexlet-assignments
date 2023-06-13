package exercise.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import static exercise.Data.getCompanies;

public class CompaniesServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        // BEGIN
        PrintWriter out = response.getWriter();

        String queryString;
        if (request.getQueryString() == null) {
            queryString = "";
        } else {
            queryString = request.getQueryString();
        }

        String parameter;
        if (request.getParameter("search") == null) {
            parameter = "";
        } else {
            parameter = request.getParameter("search");
        }

        List<String> result = getCompanies().stream()
                .filter(x -> x.contains(parameter)).toList();
        if (queryString.length() == 0 || parameter.length() == 0) {
            getCompanies();
        }
        if (result.size() == 0) {
            out.println("Companies not found");
        } else {
            result.forEach(x -> out.println(x));
        }

        // END
    }
}
