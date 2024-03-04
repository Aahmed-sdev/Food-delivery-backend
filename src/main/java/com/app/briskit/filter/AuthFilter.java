package com.app.briskit.filter;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;

import com.app.briskit.utils.ERROR;
import com.app.briskit.utils.JwtUtil;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
public class AuthFilter implements Filter {
	
	@Autowired
	private JwtUtil jwtUtil;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthFilter.class);

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String uri = request.getRequestURI();
		
		/* To-do Role based auth
		String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
		if(StringUtils.isEmpty(authHeader)) {
			// 
		}
		String[] tokenArr = authHeader.split(" ");
		String authToken = tokenArr[tokenArr.length-1];
		
		
		validateAndProcessJwtToken(authToken, response);
		
		*/
		LOGGER.info("Logging Request {} : {}",request.getMethod(), uri);
		
		filterChain.doFilter(request, response);
	}
	
	private void validateAndProcessJwtToken(String authToken, HttpServletResponse response) throws IOException {
		ERROR error = jwtUtil.validateToken(authToken);
		if(ERROR.NONE == error){
			return;
		}else if(ERROR.EXPIRED == error) {
			response.setStatus(HttpServletResponse.SC_OK);
			response.getWriter().write("Session expired");
			response.getWriter().flush();
			response.getWriter().close();
		}else if(ERROR.INVALID == error) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			response.getWriter().write("Invalid auth token");
			response.getWriter().flush();
			response.getWriter().close();
		}
	}

}
