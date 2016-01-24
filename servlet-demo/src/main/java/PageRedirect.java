/**
 * Created by marszhou on 16/1/24.
 */
import java.io.*;
import java.sql.Date;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class PageRedirect extends HttpServlet{

    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException
    {
        // 设置响应内容类型
        response.setContentType("text/html");

        // 要重定向的新位置
        String site = new String("http://www.w3cschool.cc");

        response.setStatus(response.SC_MOVED_TEMPORARILY);
        response.setHeader("Location", site);
    }
}
