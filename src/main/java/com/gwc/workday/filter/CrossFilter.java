package com.gwc.workday.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * <p>Title: </p>
 * <p>Description: 代码描述</p>
 * <p>Copyright:  gridsum.com</p>
 * <p>Company: 北京国双科技</p>
 *
 * @author yuanchangjin
 * @Date:Created in 17:44 2017/9/21
 */
@Component
public class CrossFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(CrossFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.debug("----CrossFilter init----");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        servletResponse.setHeader("Access-Control-Allow-Origin", "*");
        servletResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
        servletResponse.setHeader("Access-Control-Allow-Headers", "*,X-Request-Token,Cache-Control,Content-Language,Content-Type,Expires,Last-Modified,Pragma,X-Requested-With");
        servletResponse.setHeader("Access-Control-Max-Age", "1728000");

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        if (null != httpRequest && "OPTIONS".equalsIgnoreCase(httpRequest.getMethod())) {
            return;
        }

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }


}
