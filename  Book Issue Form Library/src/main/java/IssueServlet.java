
import java.io.*;
import java.time.LocalDate;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/issue")
public class IssueServlet extends HttpServlet {

    static int count = 1;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String usn = request.getParameter("usn");
        String book = request.getParameter("book");
        String author = request.getParameter("author");
        String date = request.getParameter("date");

        LocalDate issueDate = LocalDate.parse(date);
        LocalDate dueDate = issueDate.plusDays(14);

        String issueId = "ISS" + String.format("%03d", count++);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h2>Library Issue Slip</h2>");
        out.println("Issue ID: " + issueId + "<br>");
        out.println("Name: " + name + "<br>");
        out.println("USN: " + usn + "<br>");
        out.println("Book: " + book + "<br>");
        out.println("Author: " + author + "<br>");
        out.println("Issue Date: " + issueDate + "<br>");
        out.println("Due Date: " + dueDate + "<br>");
    }
}