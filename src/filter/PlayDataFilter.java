package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class PlayDataFilter
 */
@WebFilter("/*")
public class PlayDataFilter implements Filter {

    /**
     * Default constructor.
     */
    public PlayDataFilter() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // TODO Auto-generated method stub
        // place your code here
        String servlet_path = ((HttpServletRequest) request).getServletPath();

        //プレイ以外にアクセスした場合
        if (!servlet_path.matches("/play.*")) {
            HttpSession session = ((HttpServletRequest) request).getSession();
            if (session.getAttribute("player") != null) {
                //sesionのplayerとdealerを削除
                session.removeAttribute("player");
                session.removeAttribute("dealer");
                System.out.println("delete PlayData");
            }
        }
        // pass the request along the filter chain
        chain.doFilter(request, response);
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        // TODO Auto-generated method stub
    }

}
