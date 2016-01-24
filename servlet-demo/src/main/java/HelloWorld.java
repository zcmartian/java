import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by marszhou on 16/1/23.
 */
public class HelloWorld extends HttpServlet {
    private String message;

    @Override
    public void init() throws ServletException {
        message = "Hello world";
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        Locale locale = request.getLocale();
        String language = locale.getLanguage();
        String country = locale.getCountry();
        PrintWriter out = response.getWriter();
        String title = "检测区域设置";
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 "
                + "transitional//en\">\n";
        out.print("<h1>" + message + " (from /HelloWorld)</h1>");
        out.println(docType + "<html>\n" + "<head><title>" + title
                + "</title></head>\n" + "<body bgcolor=\"#f0f0f0\">\n"
                + "<h1 align=\"center\">" + language + "</h1>\n"
                + "<h2 align=\"center\">" + country + "</h2>\n"
                + "</body></html>");

        String date = DateFormat.getDateTimeInstance(DateFormat.FULL,
                DateFormat.SHORT, locale).format(new Date());

        out.println(docType + "<html>\n" + "<head><title>" + title
                + "</title></head>\n" + "<body bgcolor=\"#f0f0f0\">\n"
                + "<h1 align=\"center\">" + date + "</h1>\n" + "</body></html>");

        NumberFormat nft = NumberFormat.getCurrencyInstance(locale);
        String formattedCurr = nft.format(1000000);

        out.println(docType + "<html>\n" + "<head><title>" + title
                + "</title></head>\n" + "<body bgcolor=\"#f0f0f0\">\n"
                + "<h1 align=\"center\">" + formattedCurr + "</h1>\n"
                + "</body></html>");

        String formattedPerc = nft.format(0.51);

        out.println(docType + "<html>\n" + "<head><title>" + title
                + "</title></head>\n" + "<body bgcolor=\"#f0f0f0\">\n"
                + "<h1 align=\"center\">" + formattedPerc + "</h1>\n"
                + "</body></html>");
    }

    @Override
    public void destroy() {
        // do nothing;
    }
}
