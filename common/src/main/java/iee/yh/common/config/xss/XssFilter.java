package iee.yh.common.config.xss;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 定义Xss过滤器
 * @author yanghan
 * @date 2022/6/18
 */
@WebFilter(urlPatterns = "/*")
public class XssFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        XssHttpServletRequestWrapper requestWrapper = new XssHttpServletRequestWrapper(request);
        filterChain.doFilter(requestWrapper,servletResponse);
    }
}
