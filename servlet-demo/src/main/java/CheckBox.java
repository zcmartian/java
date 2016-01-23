import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by marszhou on 16/1/23.
 */
public class CheckBox extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        String title = "读取复选框数据";
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 "
                + "transitional//en\">\n";
        out.println(docType + "<html>\n" + "<head><title>" + title
                + "</title></head>\n" + "<body bgcolor=\"#f0f0f0\">\n"
                + "<h1 align=\"center\">" + title + "</h1>\n" + "<ul>\n"
                + "  <li><b>数学标识：</b>: " + request.getParameter("maths") + "\n"
                + "  <li><b>物理标识：</b>: " + request.getParameter("physics")
                + "\n" + "  <li><b>化学标识：</b>: "
                + request.getParameter("chemistry") + "\n" + "</ul>\n"
                + "</body></html>");
    }
}
