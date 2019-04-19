import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * Created by marszhou on 16/1/23.
 */
public class LogFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        String testParam = filterConfig.getInitParameter("test-param");
        System.out.println("Test param: " + testParam);
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        String ipAddress = request.getRemoteAddr();
        System.out.println("IP " + ipAddress + ", Time "
                + new Date().toString());
        chain.doFilter(request, response);
    }

    public void destroy() {

    }
}
