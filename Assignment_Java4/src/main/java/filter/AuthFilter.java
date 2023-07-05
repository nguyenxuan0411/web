package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.SessionUtils;

@WebFilter({"/Favorite", "/LikeVideo", "/UnlikeVideo", "/ShareVideo", "/HomeAdmin", "/Report", "/ChangePassword", "/EditProfile", "/video/*", "/user/*"})
public class AuthFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse) response;
		if (!SessionUtils.isLogin((HttpServletRequest) request)) {
			resp.sendRedirect("Login");
			return;
		}
		request.setAttribute("isLogin", SessionUtils.isLogin((HttpServletRequest) request));
		chain.doFilter(request, response);
	}
}
